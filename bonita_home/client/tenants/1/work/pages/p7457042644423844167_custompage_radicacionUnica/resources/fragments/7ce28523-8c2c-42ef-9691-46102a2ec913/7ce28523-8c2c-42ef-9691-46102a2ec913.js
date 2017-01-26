var module;
try {
  module = angular.module('bonitasoft.ui.fragments');
} catch (e) {
  module = angular.module('bonitasoft.ui.fragments', []);
  angular.module('bonitasoft.ui').requires.push('bonitasoft.ui.fragments');
}
module.directive('pbFragmentFragProductoSubProducto', function() {
  return {
    template: '<div>    <div class="row">\n        <div pb-property-values=\'8204feef-c0a7-47f5-9fe7-813a648559f0\'>\n    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'be16da5e-e6fb-4590-b48a-fffc31866fdb\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-2  col-lg-2" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div><div pb-property-values=\'9a66f6b6-2b29-473e-a859-081e8d49af8b\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div><div pb-property-values=\'b58cd396-7ea1-4fce-9f1e-5d7aa28209a1\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <custom-currency></custom-currency>\n    </div>\n</div><div pb-property-values=\'4a009788-bfe4-4f80-822a-f597b41b6de0\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-2  col-lg-2" ng-class="properties.cssClasses">\n        <custom-input></custom-input>\n    </div>\n</div><div pb-property-values=\'1691959b-824a-405f-83b5-801c807d65ef\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-2  col-lg-2" ng-class="properties.cssClasses">\n        <custom-input></custom-input>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'c854311c-be6f-4d3d-97e2-a54312178ee4\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-text></pb-text>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </div>\n</div>'
  };
});
