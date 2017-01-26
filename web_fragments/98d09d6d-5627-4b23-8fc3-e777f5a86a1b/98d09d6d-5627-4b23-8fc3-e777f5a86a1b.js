var module;
try {
  module = angular.module('bonitasoft.ui.fragments');
} catch (e) {
  module = angular.module('bonitasoft.ui.fragments', []);
  angular.module('bonitasoft.ui').requires.push('bonitasoft.ui.fragments');
}
module.directive('pbFragmentFragTipologiasCasuisticasRecepcionDoc', function() {
  return {
    template: '<div>    <div class="row">\n        <div pb-property-values=\'204d08a7-1ccc-4dd8-af9c-1292d6e6f1ec\'>\n    <form novalidate class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses" name="$form" method="GET" action="#"\n          ng-if="!properties.hidden">\n        <div pb-property-values=\'861ef87b-27ea-4301-97b1-950b75d1ba9e\'>\n    <div class="col-xs-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'3bc31dd4-00e7-4a64-8c57-3371e28fc7f3\'>\n    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'84c789af-9bc7-4c42-9f16-8c27279e8041\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-6  col-lg-6" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div><div pb-property-values=\'d426bf0e-d762-4396-8af6-97196af112dd\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-6  col-lg-6" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </div>\n\n    </div>\n</div>\n\n\n    </form>\n</div>\n\n    </div>\n</div>'
  };
});
