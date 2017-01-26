var module;
try {
  module = angular.module('bonitasoft.ui.fragments');
} catch (e) {
  module = angular.module('bonitasoft.ui.fragments', []);
  angular.module('bonitasoft.ui').requires.push('bonitasoft.ui.fragments');
}
module.directive('pbFragmentFragTipologiaCasuisticaAltaCuenta', function() {
  return {
    template: '<div>    <div class="row">\n        <div pb-property-values=\'9e116f5f-ccce-485e-b047-6d4876d1d084\'>\n    <form novalidate class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses" name="$form" method="GET" action="#"\n          ng-if="!properties.hidden">\n        <div pb-property-values=\'2d7d122e-4e7c-48c4-b42b-eaf52208388a\'>\n    <div class="col-xs-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'2dca4fc3-23af-44c9-a296-e95b2f343f55\'>\n    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'e965dba1-dd75-451f-b11b-7722c6ecb4a6\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-6  col-lg-6" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div><div pb-property-values=\'9b7db11c-3cd0-4b69-a0b2-04ad6efadd08\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-6  col-lg-6" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'58458202-3dbe-4894-a0f7-1b01e21f35da\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-text></pb-text>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </div>\n\n    </div>\n</div>\n\n\n    </form>\n</div>\n\n    </div>\n</div>'
  };
});
