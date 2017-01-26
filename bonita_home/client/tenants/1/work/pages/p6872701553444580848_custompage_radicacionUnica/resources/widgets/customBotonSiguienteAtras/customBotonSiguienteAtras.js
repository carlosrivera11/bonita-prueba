(function () {
  try {
    return angular.module('bonitasoft.ui.widgets');
  } catch(e) {
    return angular.module('bonitasoft.ui.widgets', []);
  }
})().directive('customBotonSiguienteAtras', function() {
    return {
      controllerAs: 'ctrl',
      controller: /**
 * The controller is a JavaScript function that augments the AngularJS scope and exposes functions that can be used in the custom widget template
 * 
 * Custom widget properties defined on the right can be used as variables in a controller with $scope.properties
 * To use AngularJS standard services, you must declare them in the main function arguments.
 * 
 * You can leave the controller empty if you do not need it.
 */
function ($scope) {
    
    $scope.init = function() {
        $scope.showPrevButton = $scope.getCurrentVisibleIndex() > 0;
        $scope.showNextButton = $scope.getCurrentVisibleIndex() < $scope.properties.hiddenVariablesList.length;    
    }
    
    $scope.next = function() {
        var currentVisibleIndex = $scope.getCurrentVisibleIndex();
            
        // Oculto todos
        $scope.hideAll();
    
        // Muestro la siguiente posicion   
        $scope.properties.hiddenVariablesList[currentVisibleIndex + 1] = false;
        
        // Aumento el current visible
        currentVisibleIndex++;
        
        // Si llego a la ultima posicion desactivo el boton
        if(currentVisibleIndex === $scope.properties.hiddenVariablesList.length - 1) {
            $scope.showNextButton = false;
        }
        
        
        $scope.showPrevButton = true;
    }
    
    $scope.prev = function() {
        
        var currentVisibleIndex = $scope.getCurrentVisibleIndex();
            
        // Oculto todos
        $scope.hideAll();
    
        // Muestro la siguiente posicion   
        $scope.properties.hiddenVariablesList[currentVisibleIndex - 1] = false;
        
        // Disminuyo el current visible index
        currentVisibleIndex--;
        
        // Si llego a la primera pagina desactivo el boton atras
        if(currentVisibleIndex === 0) {
            $scope.showPrevButton = false;
        }
        
        $scope.showNextButton = true;
    }
    
    $scope.getCurrentVisibleIndex = function() {
        for(var i = 0; i < $scope.properties.hiddenVariablesList.length; i++) {
            if($scope.properties.hiddenVariablesList[i] === false) {
                return i;
            }
        } 
        
        return 0;
    }
    
    $scope.hideAll = function() {
        for(var i = 0; i < $scope.properties.hiddenVariablesList.length; i++) {
            $scope.properties.hiddenVariablesList[i] = true;
        }   
    }
},
      template: '<!-- The custom widget template is defined here\n   - You can use standard HTML tags and AngularJS built-in directives, scope and interpolation system\n   - Custom widget properties defined on the right can be used as variables in a templates with properties.newProperty\n   - Functions exposed in the controller can be used with ctrl.newFunction()\n -->\n \n<div ng-init="init()">\n    <span class="pull-left">\n        <button type="button" class="btn btn-primary" aria-label="Left Align" ng-click="prev()" ng-show="showPrevButton">\n            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> Anterior\n        </button>\n    </span>\n    \n    <span class="pull-right">\n        <button type="button" class="btn btn-primary" aria-label="Left Align" ng-click="next()" ng-show="showNextButton">\n            Siguiente <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>\n        </button>\n    </span>\n    \n    {{properties.containersClasses}}\n</div>'
    };
  });
