(function () {
  try {
    return angular.module('bonitasoft.ui.widgets');
  } catch(e) {
    return angular.module('bonitasoft.ui.widgets', []);
  }
})().directive('pbRadioButtons', function() {
    return {
      controllerAs: 'ctrl',
      controller: function PbRadioBoxCtrl($scope, $parse, $log, widgetNameFactory) {

  'use strict';
  var ctrl = this;
  /**
   * Watch the data source and set wrapChoices and $scope.properties.values
   */
  function comparator(initialValue, item) {
    return angular.equals(initialValue, ctrl.getValue(item));
  }

  function createGetter(accessor) {
    return accessor && $parse(accessor);
  }

  this.getLabel = createGetter($scope.properties.displayedKey) || function (item) {
    return typeof item === 'string' ? item : JSON.stringify(item);
  };
  this.getValue = createGetter($scope.properties.returnedKey) || function (item) {
    return item;
  };

  $scope.$watch('properties.availableValues', function(items){
    if (Array.isArray(items)) {
      var foundValue = items
        .filter(comparator.bind(null, $scope.properties.selectedValue))
        .reduce(function (acc, item) {
          return ctrl.getValue(item);
        }, undefined);
      if (foundValue) {
        $scope.properties.selectedValue = foundValue;
      }
    }
  });

  this.name = widgetNameFactory.getName('pbRadioBox');

  if (!$scope.properties.isBound('selectedValue')) {
    $log.error('the pbRadioBox property named "selectedValue" need to be bound to a variable');
  }
}
,
      template: '<div ng-class="{\n    \'form-horizontal\': properties.labelPosition === \'left\' && !properties.labelHidden,\n    \'row\': properties.labelPosition === \'top\' && !properties.labelHidden || properties.labelHidden\n    }">\n    <div class="form-group">\n        <label\n            ng-if="!properties.labelHidden"\n            ng-class="{ \'control-label--required\': properties.required }"\n            class="control-label col-xs-{{ !properties.labelHidden && properties.labelPosition === \'left\' ? properties.labelWidth : 12 }}">\n        {{ properties.label | uiTranslate }}\n        </label>\n        <div class="col-xs-{{ 12 - (!properties.labelHidden && properties.labelPosition === \'left\' ? properties.labelWidth : 0) }}">\n            <label ng-if="properties.inline" class="radio-inline" ng-repeat="option in properties.availableValues track by $index">\n                <input\n                    type="radio"\n                    name="{{ctrl.name}}"\n                    ng-model="properties.selectedValue"\n                    ng-value="ctrl.getValue(option)"\n                    ng-required="properties.required"\n                    ng-disabled="properties.disabled">\n                {{ (ctrl.getLabel(option) || option) | uiTranslate }}\n            </label>\n\n            <div ng-if="!properties.inline" class="radio" ng-repeat="option in properties.availableValues track by $index">\n                <label>\n                    <input\n                        type="radio"\n                        name="{{ctrl.name}}"\n                        ng-model="properties.selectedValue"\n                        ng-value="ctrl.getValue(option)"\n                        ng-required="properties.required"\n                        ng-disabled="properties.disabled">\n                    {{ (ctrl.getLabel(option) || option) | uiTranslate }}\n                </label>\n            </div>\n        </div>\n        <div ng-messages="$form[ctrl.name].$dirty && $form[ctrl.name].$error " ng-messages-include="forms-generic-errors.html" role="alert"></div>\n    </div>\n</div>\n'
    };
  });
