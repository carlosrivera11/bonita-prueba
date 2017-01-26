var inputModule = angular.module('inputModule', [])

inputModule.directive('ngInputNumber', function() {    
    return { 
        restrict: 'A',        
        link : function (scope, element, attrs) {		
			setTimeout(function() {
				$(element).number(true, 0, '', '');			
			}, 0);				
        }
    }
});