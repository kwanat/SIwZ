/**
 * Created by sicluceatlux on 2017-03-17.
 */


var cartApp = angular.module('cartApp',[]);

cartApp.controller('cartCtrl',function ($scope, $http){
    $scope.refreshCart = function (){
        $http.get('/FirstSpringProject/rest/cart/'+$scope.cartId).success(function(data){
            $scope.cart=data;
        });
    };

    $scope.clearCart = function(){
        $http.delete('/FirstSpringProject/rest/cart/'+$scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(productId){
        //alert("Prepared to add product to the cart!")
        $http.put('/FirstSpringProject/rest/cart/add/'+productId).success(function(){
            $scope.refreshCart($http.get('/FirstSpringProject/rest/cart/cartId'));
            alert("Product successfully added to the cart!")
        });
    };

    $scope.removeFromCart = function(productId){
        $http.put('/FirstSpringProject/rest/cart/remove/'+productId).success(function(data){
            $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal=0;
        for (var i=0; i<$scope.cart.cartItems.length; i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }
        return grandTotal;
    }
});