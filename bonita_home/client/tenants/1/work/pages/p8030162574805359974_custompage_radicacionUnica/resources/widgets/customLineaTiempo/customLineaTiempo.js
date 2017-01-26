(function () {
  try {
    return angular.module('bonitasoft.ui.widgets');
  } catch(e) {
    return angular.module('bonitasoft.ui.widgets', []);
  }
})().directive('customLineaTiempo', function() {
    return {
      controllerAs: 'ctrl',
      controller: 
function ($scope) {

    $scope.getItemLeft = function($index) {
        var leftPerItem = parseInt(100 / ($scope.properties.hiddenVariablesList.length - 1));
        
        return (leftPerItem * $index) + "%";
    }  
    
    $scope.getActiveBarWidth = function() {
        var widthPerItem = parseInt(100 / ($scope.properties.hiddenVariablesList.length - 1));
        
        return (widthPerItem * $scope.getCurrentVisibleIndex()) + "%";
    }
    
    $scope.getLabelMarginLeft = function(e) {
        var as = "asd";
    }
    
    $scope.isActiveItem = function($index) {
        var currentVisibleIndex = $scope.getCurrentVisibleIndex();
        
        return $index <= currentVisibleIndex;
    }
    
    $scope.getCurrentVisibleIndex = function() {
        for(var i = 0; i < $scope.properties.hiddenVariablesList.length; i++) {
            if($scope.properties.hiddenVariablesList[i] === false) {
                return i;
            }
        } 
        
        return 0;
    }
},
      template: '<div class="col-md-12 linea-tiempo-bar">\n    <ol>\n        <li ng-repeat="var in properties.hiddenVariablesList track by $index" style="left: {{ getItemLeft($index) }};"\n            ng-class="{\'active\' : isActiveItem($index)}">\n            <div ng-class="{\'active\' : isActiveItem($index)}" ng-center-label >{{properties.labelsList[$index]}}</div>\n        </li>\n    </ol>\n    <div class="active-bar" style="width: {{getActiveBarWidth()}}"></div>\n</div>'
    };
  });
