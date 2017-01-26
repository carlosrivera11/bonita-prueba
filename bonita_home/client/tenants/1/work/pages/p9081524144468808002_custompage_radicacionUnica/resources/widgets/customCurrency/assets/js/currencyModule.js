var currencyModule = angular.module('currencyModule', [])

currencyModule.directive('ngCurrencyFormat', function() {    
    return { 
        restrict: 'A',        
        link : function (scope, element, attrs) {				
			$(element).number(true, 2);	
			$(element).keyup(function() {
				var el = this;
				scope.$apply(function() {
					scope.properties.value = $(el).val();
				});				
			});
        }
    }
});