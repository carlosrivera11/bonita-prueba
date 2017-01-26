(function () {
  try {
    return angular.module('bonitasoft.ui.widgets');
  } catch(e) {
    return angular.module('bonitasoft.ui.widgets', []);
  }
})().directive('customInput', function() {
    return {
      controllerAs: 'ctrl',
      controller: 
function ($scope) {
    
    $scope.inputErrors = function() {
        if($scope.$eval("$form." + $scope.$eval("properties.name") + ".$dirty")) {
            return  $scope.$eval("$form." + $scope.$eval("properties.name") + ".$error");
        }
        
        return {};
    }
    
    $scope.hasErrors = function() {
        return Object.keys($scope.inputErrors()).length > 0;
    }
    
},
      template: '<div class="form-group custom-input-container">\n    <label for="{{properties.id}}" class="control-label" ng-class="{\'has-errors\': hasErrors()}">{{properties.label}}<span ng-show="properties.required" class="required"> *</span></label>\n    \n    <input  class="form-control"\n            type="{{properties.type}}" \n            id="{{properties.name}}"\n            name="{{properties.name}}" \n            placeholder={{properties.placeholder}}\n            ng-class="{\'has-errors\': hasErrors()}"\n            ng-disabled="properties.disabled"\n            ng-max="properties.max"\n            ng-min="properties.min"\n            ng-maxlength="properties.maxlength"\n            ng-minlength="properties.minlength"\n            ng-readonly="properties.readonly"\n            ng-required="properties.required"\n            ng-model="properties.value"\n            ng-input-pattern="properties.pattern">\n    \n    <ul class="input-errors-list" ng-show="hasErrors()">\n        <li ng-show="inputErrors().email">Debe ingresar una dirección de correo electronico válida (ej: usuario@dominio.com)</li>            \n        <li ng-show="inputErrors().required">El campo es obligatorio</li>\n        <li ng-show="inputErrors().max">El valor del campo debe ser menor a {{properties.max}}</li>\n        <li ng-show="inputErrors().min">El valor del campo debe ser mayor a {{properties.min}}</li>\n        \n        <li ng-show="inputErrors().maxlength && properties.maxlength != properties.minlength">El largo del campo debe ser menor o igual a {{properties.maxlength}}</li>\n        <li ng-show="inputErrors().minlength && properties.minlength != properties.maxlength">El largo del campo debe ser mayor o igual a {{properties.minlength}}</li>\n		<li ng-show="(inputErrors().maxlength || inputErrors().minlength) && properties.maxlength == properties.minlength">El largo del campo debe ser igual a {{properties.maxlength}}</li>		\n		\n        <li ng-show="inputErrors().pattern">El contenido del campo no cohincide con el patrón \'{{properties.pattern}}\'</li>\n        <li ng-show="inputErrors().url">Debe ingresar una URL válida (ej: http://www.dominio.com)</li>\n    </ul>\n</div>'
    };
  });
