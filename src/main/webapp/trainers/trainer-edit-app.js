
new Vue({
    el: "#app",
    data: {
        fullName: "${trainer.name} ${trainer.surname}"
    },
    computed: {
        fullName: function () {
            return "${trainer.name} ${trainer.surname}";
        }
    }
})