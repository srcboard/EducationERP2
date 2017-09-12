new Vue({
    el: '#app',
    data: {
        users: []
    },
    ready: function () {
        // GET /users
        this.$http.get('/users').then(
            function (response) { // Success.
                this.users = response.data;
            },
            function (response) { // Error.
                console.log('An error occurred.');
            }
        );
    },
    methods: {
        reverse: function () {
            this.users.reverse();
        }
    }
});