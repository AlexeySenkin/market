angular.module('market', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http.get('http://localhost:8189/market/api/v1/products')
            .then(function (response) {
                $scope.products = response.data;
                //console.log(response);
            });
    };

    $scope.showProductInfo = function (id) {
        $http.get('http://localhost:8189/market/api/v1/products/' + id)
            .then(function (response) {
                //$scope.products = response.data;
                //console.log(response);
                alert(response.data.title)
            });
    }

    $scope.deleteProduct = function (id) {
        $http.delete('http://localhost:8189/market/api/v1/products/' + id)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.createNewProduct = function () {
        // console.log($scope.newProduct);
        $http.post('http://localhost:8189/market/api/v1/products', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.loadProducts();
            });
    }

    $scope.loadCart = function () {
        $http.get('http://localhost:8189/market/api/v1/cart')
            .then(function (response) {
                $scope.cart = response.data;
            });
    }

    $scope.addProductToCart = function (productId) {
        $http.get('http://localhost:8189/market/api/v1/cart/add/' + productId)
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.deleteProductFromCart = function (productId) {
        $http.get('http://localhost:8189/market/api/v1/cart/delete/' + productId)
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.deleteAllProductFromCart = function () {
        $http.get('http://localhost:8189/market/api/v1/cart/delete/all')
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.loadProducts();
    $scope.loadCart();
});