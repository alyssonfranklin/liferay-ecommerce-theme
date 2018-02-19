<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div id="wrapper">
	<header class="container-fluid-1280" id="banner" role="banner">
		<div class="row">
			<div class="navbar-header" id="heading">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="64" src="${site_logo}" width="64" />
				</a>

				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>

				<#if is_setup_complete>
					<button aria-controls="navigation" aria-expanded="false" class="collapsed navbar-toggle" data-target="#navigationCollapse" data-toggle="collapse" type="button">
						<span class="icon-bar"></span>

						<span class="icon-bar"></span>

						<span class="icon-bar"></span>
					</button>

					<div class="pull-right user-personal-bar">
						<@liferay.user_personal_bar />
					</div>
				</#if>

        <#if has_navigation && is_setup_complete>
          <div class="navbar-form navbar-right" role="search">
            <#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "barebone")>
            <@liferay.search default_preferences="${freeMarkerPortletPreferences}" />
            <#assign VOID = freeMarkerPortletPreferences.reset()>
          </div>
        </#if>

			</div>

      
		</div>

    <div class="row">
      <div class="col-md-12">
        <#include "${full_templates_path}/navigation.ftl" />
      </div>
    </div>
	</header>

	<section class="container-fluid-1280" id="content">
		<h1 class="hide-accessible">${the_title}</h1>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	<footer class="container-fluid-1280" id="footer" role="contentinfo">
		<#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "barebone") />
    <#assign theme_groupID = htmlUtil.escape(theme_display.getCompanyGroupId()?string) />
    <#assign VOID = freeMarkerPortletPreferences.setValue("groupId", '${group_id}') />
    <#assign VOID = freeMarkerPortletPreferences.setValue("articleId", "FOOTER-LOGO") />



    <@liferay_portlet["runtime"]
      defaultPreferences="${freeMarkerPortletPreferences}"
      portletProviderAction=portletProviderAction.VIEW
      instanceId="footercontent"
      portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" 
    />
    ${freeMarkerPortletPreferences.reset()}
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>
