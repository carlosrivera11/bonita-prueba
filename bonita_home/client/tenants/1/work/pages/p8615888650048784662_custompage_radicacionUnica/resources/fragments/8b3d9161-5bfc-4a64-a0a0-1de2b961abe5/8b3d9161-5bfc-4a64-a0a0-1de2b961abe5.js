var module;
try {
  module = angular.module('bonitasoft.ui.fragments');
} catch (e) {
  module = angular.module('bonitasoft.ui.fragments', []);
  angular.module('bonitasoft.ui').requires.push('bonitasoft.ui.fragments');
}
module.directive('pbFragmentFragInformacionComercial', function() {
  return {
    template: '<div>    <div class="row">\n        <div pb-property-values=\'eca97c1e-61ec-44e0-9489-ca7169015a98\'>\n    <form novalidate class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses" name="$form" method="GET" action="#"\n          ng-if="!properties.hidden">\n        <div pb-property-values=\'03af7703-d93e-41da-ba49-b98bf292d489\'>\n    <div class="col-xs-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'746a1cc4-8bb9-4743-933d-0023939f1dd5\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-text></pb-text>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'4cd35092-dcd2-4c93-b3fe-34417a3c9b88\'>\n    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'f3aba158-5aa9-4cff-b282-09f00c0930ed\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-4  col-lg-4" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div><div pb-property-values=\'72f1754a-783e-45d9-a936-788af45e68da\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-5  col-lg-5" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div><div pb-property-values=\'c0d6838e-2bb8-4f4f-80ce-f46c545be8de\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </div>\n    <div class="row">\n        <div pb-property-values=\'474aa6e4-7b73-4089-a446-65074e8d4645\'>\n    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'592a04e8-42d5-4304-ab1c-a60bab03d613\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-4  col-lg-4" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'155a97cc-823e-4a26-a3ba-c19d13b1bd79\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div><div pb-property-values=\'834d3bb2-59e5-4cbf-8b23-38aee21ef96c\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div><div pb-property-values=\'e5b82deb-ad00-4197-bec5-3991edd69fe3\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div><div pb-property-values=\'cf397585-2e2a-4f7e-9f66-00ced924a1aa\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </div>\n    <div class="row">\n        <div pb-property-values=\'f204a462-ca8f-4cf7-ae15-35d7c3838f60\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-4  col-lg-4" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div><div pb-property-values=\'3bbca364-b2d2-4ed9-a48f-3e1257e856f3\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-5  col-lg-5" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div><div pb-property-values=\'231f2953-0f4f-49a9-ae15-c96323dad0a1\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <pb-input></pb-input>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'b937c7b7-3d76-4b6e-a558-40cf15d88837\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-title></pb-title>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </form>\n</div>\n\n    </div>\n</div>'
  };
});
