var module;
try {
  module = angular.module('bonitasoft.ui.fragments');
} catch (e) {
  module = angular.module('bonitasoft.ui.fragments', []);
  angular.module('bonitasoft.ui').requires.push('bonitasoft.ui.fragments');
}
module.directive('pbFragmentFragInformacionCliente', function() {
  return {
    template: '<div>    <div class="row">\n        <div pb-property-values=\'0d323273-1766-459a-b439-903b15ff322e\'>\n    <form novalidate class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses" name="$form" method="GET" action="#"\n          ng-if="!properties.hidden">\n        <div pb-property-values=\'19c340ae-417f-4722-9e01-9d738019cab8\'>\n    <div class="col-xs-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'31bd2f30-91cf-4332-912c-ba1d18509a50\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-title></pb-title>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'c26373b5-8441-4516-ad7d-6c55908ae9c6\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-4  col-lg-4" ng-class="properties.cssClasses">\n        <custom-input></custom-input>\n    </div>\n</div><div pb-property-values=\'324940a3-cbfd-4924-a798-7c6779689a36\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <custom-input></custom-input>\n    </div>\n</div><div pb-property-values=\'4eeac449-ced2-41fc-b191-6de131a3e63a\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-2  col-lg-2" ng-class="properties.cssClasses">\n        <pb-radio-buttons></pb-radio-buttons>\n    </div>\n</div><div pb-property-values=\'aceb7f15-6231-420a-a12c-f6efd34d588a\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <custom-input></custom-input>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'867e672c-f683-4348-8efc-c696399cc168\'>\n    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" ng-repeat="$item in ($collection = properties.repeatedCollection) track by $index">\n            <div class="row">\n        <div pb-property-values=\'60dc2df0-c85e-40e2-88f5-55779723528b\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-title></pb-title>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </div>\n    <div class="row">\n        <div pb-property-values=\'a22cf4f3-5d4d-4910-9f80-f79c331a2c4c\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-4  col-lg-4" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'633f3724-862b-423a-97e1-ff1f24ca40a7\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-text></pb-text>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'7632b765-a93a-4571-835b-95d7307efc5d\'>\n    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" >\n            <div class="row">\n        <div pb-property-values=\'507e542d-1c20-488f-85cf-6a70fc0aa2cb\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-title></pb-title>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'98a070f9-4a7f-4a61-af49-cb465a61932d\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-text></pb-text>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'2b9b85bd-82fb-4deb-bdcc-43f4a8888a18\'>\n    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses"\n         ng-if="!properties.hidden" ng-repeat="$item in ($collection = properties.repeatedCollection) track by $index">\n            <div class="row">\n        <div pb-property-values=\'14d32809-bf5f-49e4-93aa-61f438564bfe\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <custom-input></custom-input>\n    </div>\n</div><div pb-property-values=\'0fe27762-9dab-41bb-a8c1-c5130615bfd1\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div><div pb-property-values=\'14448d0a-c554-44f7-b445-15a1856c9b6a\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <custom-input></custom-input>\n    </div>\n</div><div pb-property-values=\'10321c1e-2388-4461-8eb7-6f0b5abcaf50\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-3  col-lg-3" ng-class="properties.cssClasses">\n        <pb-select></pb-select>\n    </div>\n</div>\n    </div>\n    <div class="row">\n        <div pb-property-values=\'ed666ed1-ce74-4962-8575-96d0960b6838\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-button></pb-button>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </div>\n    <div class="row">\n        <div pb-property-values=\'cd972e04-44dc-431f-986b-9f34921492f5\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-button></pb-button>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </div>\n    <div class="row">\n        <div pb-property-values=\'9d56f697-a874-47f3-beb0-f161ed1f9489\'>\n    <div ng-if="!properties.hidden" class="component col-xs-12  col-sm-12  col-md-12  col-lg-12" ng-class="properties.cssClasses">\n        <pb-text></pb-text>\n    </div>\n</div>\n    </div>\n\n    </div>\n</div>\n\n\n    </form>\n</div>\n\n    </div>\n</div>'
  };
});