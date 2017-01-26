var inputModule = angular.module('inputModule', [])

inputModule.directive('ngInputPattern', function() {    
    return { 
        restrict: 'A',        
        link : function (scope, element, attrs) {		
			if(attrs.ngInputPatter) {				
				var regExp = new RegExp(scope.$eval(attrs.ngInputPattern));
				var acceptedKeys = [8, 9, 35, 36, 37, 38, 39, 40, 46];
				$(element).keydown(function(event) {
					return acceptedKeys.indexOf(event.keyCode) != -1 || regExp.test(event.key);
				});
			}
        }
    }
});