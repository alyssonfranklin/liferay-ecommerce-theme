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
AUI().ready(
	'liferay-sign-in-modal', 'liferay-alert',
	function(A) {
		var signIn = A.one('.sign-in > a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}

	    $(function() {
	      // Product View image click
	      $('.side-image').click(function() {
	        var $imageLink = $(this).find('img').data('src');
	        $('.main-image').find('img').attr('src', $imageLink);
	      });
	    });
	    
	    // init cart
	    
	    var curLayout = Liferay.ThemeDisplay.getLayoutURL();
	    var pos = curLayout.lastIndexOf("/");
	    var cartURL = curLayout.substr(0,pos)+'/cart';
    
	    var url = Liferay.PortletURL.createURL(cartURL);
	    url.setLifecycle(Liferay.PortletURL.RESOURCE_PHASE);
	    url.setPortletId('com_rivetlogic_ecommerce_portlet_ShoppingCart');
	    url.setResourceId('getCartInfo');
      
	    $.post(url.toString()).done(function( data ) {
	    	var result = JSON.parse(data); 
	    	var items= result.cartDetails.quantity;
	    	if (items==0){
	    		var badge = $("#cart_badge");
	    		badge.html("");
	    		badge.hide();
	    	}
	    	else {
	    		var badge = $("#cart_badge");
	    		badge.html(items);
	    		badge.show();
	    	}
	    });

		$('#product-list').on('click', '.add-to-cart-js', function (e){
		
		  var id = $(e.currentTarget).data('articleId');
		  var product = $(e.currentTarget).data('productTitle');
		  var link = $(e.currentTarget).data('addLink');      
		
		  var url = Liferay.PortletURL.createURL(link);
		  url.setLifecycle(Liferay.PortletURL.RESOURCE_PHASE);
		  url.setPortletId('com_rivetlogic_ecommerce_portlet_ShoppingCart');
		  url.setResourceId('addCartItem');
		  url.setParameter('itemId', id);
		  url.setParameter('itemName', product);
		  
		  $.post(url.toString())
		    .done(function( data ) {
		      var result = JSON.parse(data); 
		        var items= result.cartDetails.quantity;
		      if(items==0){
		        var badge = $("#cart_badge");
		        badge.html("");
		        badge.hide();
		      }else{
		        var badge = $("#cart_badge");
		        badge.html(items);
		        badge.show();
		      }
		      
		      // success message
		      new Liferay.Alert(
		        {
		          delay: {
		            hide: 5000,
		            show: 0
		          },
		          message: 'Product added to your cart',
		          type: 'success',
		          closeable: true,
		          icon: 'exclamation-circle'
		        }
		      ).render('#product-list-message');
		  });
		});

		// Product View image click
		$('.side-image').click(function() {
		  var $imageLink = $(this).find('img').data('src');
		  $('.main-image').find('img').attr('src', $imageLink);
		});
	}
);

(function ($, window) {

  $(document).ready(function () {
  });


}) ($, window);
