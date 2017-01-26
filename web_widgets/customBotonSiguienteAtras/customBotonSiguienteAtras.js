(function () {
  try {
    return angular.module('bonitasoft.ui.widgets');
  } catch(e) {
    return angular.module('bonitasoft.ui.widgets', []);
  }
})().directive('customBotonSiguienteAtras', function() {
    return {
      controllerAs: 'ctrl',
      controller: function ($scope) {
    
    $scope.$watch("properties.hiddenVariablesList", function(oldValue, newValue) {
        $scope.init();
    });
    
    $scope.init = function() {
        $scope.showPrevButton = $scope.getCurrentVisibleIndex() > 0;
        $scope.showNextButton = $scope.getCurrentVisibleIndex() < ($scope.properties.hiddenVariablesList.length - 1);    
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
      template: '<div>\n    <span class="pull-left">\n        <button type="button" class="btn btn-primary" aria-label="Left Align" ng-click="prev()" ng-show="showPrevButton">\n            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> Anterior\n        </button>\n    </span>\n    \n    <span class="pull-right">\n        <button type="button" class="btn btn-primary" aria-label="Left Align" ng-click="next()" ng-show="showNextButton">\n            Siguiente <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>\n        </button>\n    </span>\n    \n    {{properties.containersClasses}}\n</div>'
    };
  });
