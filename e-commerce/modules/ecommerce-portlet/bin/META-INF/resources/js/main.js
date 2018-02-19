/**
 * Copyright (C) 2005-present Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

AUI.add('shopping-cart', function(A, NAME) {
    var ns = A.namespace("ShoppingCart");
    var pns = "";
    
    ns.setPortletNamespace = function(namespace){
        pns = namespace;
    };
    
    ns.removeCartItem = function(removeItemBtn) {
    	var deleteUrl = removeItemBtn.getData('url');
    	
        A.io.request(deleteUrl, {
            method : 'get',
            dataType : 'json',
            on : {
                success : function(event, id, obj) {
                	removeItemBtn.ancestor('.item-data-row').remove();
                	var quantity= this.get('responseData').cartDetails['quantity'];
                	if (quantity <= 0){
                		A.all('.cart-items-details').addClass('hidden');
                		A.one('#cart-empty-msg').removeClass('hidden');
                		A.one('#checkout-panel').addClass('hidden');
                		A.one('#cart_badge').addClass('hidden');
                	}
                	A.one('#cart-total-price').html('$' + this.get('responseData').cartDetails['total']);                	
                	A.one('#cart_badge').html(quantity);
                },
                error: function(event, id, obj){}
            }
        });
    };
    
    ns.doCheckout = function(checkoutUrl) {
    	var formValidator = Liferay.Form.get(pns +'form-checkout').formValidator;

		formValidator.validate();

		if (formValidator.hasErrors()) {
			return;
		}

    	A.one('#'+ pns +'form-checkout').attr('action', checkoutUrl).submit();
    };
    
    ns.updateCartItem = function(quantityInput) {
    	var updateUrl = quantityInput.getData('url');
    	var oldValue = quantityInput.getData('old-value');
    	var newValue = Math.floor(parseFloat(quantityInput.val()));
    	if(isNaN(newValue) || newValue <= 0){
    		quantityInput.set('value', oldValue);
    		return;
    	}
        A.io.request(updateUrl + '&' + pns + 'itemCount=' + newValue, {
            method : 'get',
            dataType : 'json',
            on : {
                success : function(event, id, obj) {
                	quantityInput.setData('old-value', newValue);
                	var updatedItemDetails = this.get('responseData').itemDetails;
                	quantityInput.ancestor('tr').one('.item-total-price').html('$'+updatedItemDetails.total);
                	A.one('#cart-total-price').html('$' + this.get('responseData').cartDetails['total']);
                	A.one('#cart_badge').html(this.get('responseData').cartDetails['quantity']);
                },
                error: function(event, id, obj){
                	quantityInput.set('value', oldValue);
                }
            }
        });
    };
});