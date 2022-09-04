<template>

    <v-data-table
        :headers="headers"
        :items="totalCarList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'TotalCarListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            totalCarList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/totalCarLists'))

            temp.data._embedded.totalCarLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.totalCarList = temp.data._embedded.totalCarLists;
        },
        methods: {
        }
    }
</script>

