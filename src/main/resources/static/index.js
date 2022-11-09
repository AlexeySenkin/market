angular.module('market', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage) {

    if ($localStorage.marketUser) {
        try {
            let jwt = $localStorage.marketUser.token;
            let payload = JSON.parse(atob(jwt.split('.')[1]));
            let currentTime = parseInt(new Date().getTime() / 1000);
            if (currentTime > payload.exp) {
                console.log("Token is expired!!!");
                alert("Token is expired!!!");
                delete $localStorage.marketUser;
                $http.defaults.headers.common.Authorization = '';
            }
        } catch (e) {
        }

        if ($localStorage.marketUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.marketUser.token;
        }
    }

    $scope.checkUser = function() {
        $http.get('http://localhost:8189/market/auth_check')
            .then(function successCallback(response) {
                alert(response.data.value)
            });

    }

    $scope.tryToAuth = function () {
        $http.post('http://localhost:8189/market/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {

                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.marketUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(response) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        $scope.user = null;
    };

    $scope.clearUser = function () {
        delete $localStorage.marketUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $scope.isUserLoggedIn = function () {
        return !!$localStorage.marketUser;
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

    $scope.loadOrders = function () {
        $http.get('http://localhost:8189/market/api/v1/orders')
            .then(function (response) {
                $scope.order = response.data;
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

    $scope.loadProducts = function () {
        $http.get('http://localhost:8189/market/api/v1/products')
            .then(function (response) {
                $scope.products = response.data;
                //console.log(response);
            });
    };

    $scope.createOrder = function (orderId) {
        $http.post('http://localhost:8189/market/api/v1/orders/' + orderId, $scope.newOrder)
            .then(function (response) {
                $scope.newOrder = null;
                $scope.loadProducts();
            });
    }

    $scope.loadProducts();
    $scope.loadCart();
    $scope.loadOrders()
});