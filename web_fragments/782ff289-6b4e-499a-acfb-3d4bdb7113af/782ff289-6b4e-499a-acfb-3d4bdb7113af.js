var module;
try {
  module = angular.module('bonitasoft.ui.fragments');
} catch (e) {
  module = angular.module('bonitasoft.ui.fragments', []);
  angular.module('bonitasoft.ui').requires.push('bonitasoft.ui.fragments');
}
module.directive('pbFragmentFragTipologiaCasuisticaNegado', function() {
  return {
    template: '<div>    <div class="row">\n        <div pb-property-values=\'96377280-ba76-4722-a9fb-8aefd37a5cdd\'>\n    <form novalidate class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses" name="$form" method="GET" action="#"\n          ng-if="!properties.hidden">\n        <div pb-property-values=\'2feb4676-21bb-45df-9743-69532fa7d891\'>\n    <div class="col-xs-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'12b20032-5b3e-4872-9c14-f000997f868f\'>\n    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'67f75fde-834c-42fc-8ce2-a598b3b07bef\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-6  col-lg-6" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div><div pb-property-values=\'cf40aa6e-1f72-41fc-b959-9ccb0dc0d442\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-6  col-lg-6" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'d3675e51-c311-4b7c-9be4-9bd00f6146d0\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-text></pb-text>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </div>\n\n    </div>\n</div>\n\n\n    </form>\n</div>\n\n    </div>\n</div>'
  };
});
