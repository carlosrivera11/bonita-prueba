var module;
try {
  module = angular.module('bonitasoft.ui.fragments');
} catch (e) {
  module = angular.module('bonitasoft.ui.fragments', []);
  angular.module('bonitasoft.ui').requires.push('bonitasoft.ui.fragments');
}
module.directive('pbFragmentFragTipologiaCasuisticaValidacionDesembolso', function() {
  return {
    template: '<div>    <div class="row">\n        <div pb-property-values=\'10abd1ef-0c4e-4eda-a5b4-49466b7e3ae9\'>\n    <form novalidate class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses" name="$form" method="GET" action="#"\n          ng-if="!properties.hidden">\n        <div pb-property-values=\'d1f742de-2e82-4553-b7d0-877f00fb2a36\'>\n    <div class="col-xs-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'71fbaadc-3ea8-44a1-b0d9-c9e163c2ef74\'>\n    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'452929e8-1def-4ed0-a019-c4f7d15fe9e2\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-6  col-lg-6" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div><div pb-property-values=\'ef461d32-e376-4c2e-8826-1a1f387374aa\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-6  col-lg-6" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'e97d5906-ed98-4c92-a45a-6667888413fd\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-text></pb-text>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </div>\n\n    </div>\n</div>\n\n\n    </form>\n</div>\n\n    </div>\n</div>'
  };
});
