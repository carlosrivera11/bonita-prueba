var module;
try {
  module = angular.module('bonitasoft.ui.fragments');
} catch (e) {
  module = angular.module('bonitasoft.ui.fragments', []);
  angular.module('bonitasoft.ui').requires.push('bonitasoft.ui.fragments');
}
module.directive('pbFragmentFragDatosCliente', function() {
  return {
    template: '<div>    <div class="row">\n        <div pb-property-values=\'2e0a0846-c665-42fe-8cbf-d54937dc18b6\'>\n    <form novalidate class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses" name="$form" method="GET" action="#"\n          ng-if="!properties.hidden">\n        <div pb-property-values=\'6c74c3a6-aea4-45dd-9e5c-dbeb21f01410\'>\n    <div class="col-xs-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'571a3788-e56f-40fd-952f-3cc7e2b2c792\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-8  col-lg-8" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div><div pb-property-values=\'648b47e1-adc1-4ea1-b6f8-b06979a27d71\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-4  col-lg-4" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </form>\n</div>\n\n    </div>\n</div>'
  };
});
