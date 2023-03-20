<script>

export default({
    data() {
        return{
            dbname: '',
            keyprefix: '',
            keyinfo: '',
            selectedkeyprefix: ''
        }
    },
    created() {
        this.fetchKeyPrefix()
    },
    methods: {
        hasValidInput() {
            return this.dbname.trim() && this.selectedkeyprefix.trim() && this.keyinfo.trim()
        },
        search() {
            if(this.hasValidInput()) {
                alert(this.selectedkeyprefix + "-" + this.keyinfo + "-" + this.dbname)
            } else {
                alert('invalid')
            }
        },
        async fetchKeyPrefix() {
            const url = '/api/data/getkeyprefix'
            this.keyprefix = await (await fetch(url)).json()
            // this.keyprefix = ['Prefix-1', 'Prefix-2', 'Prefix-3']
        }
    }
})
</script>


<template>
    <label><p> Name:</p>
        <select v-model="dbname" >
            <option disabled value=""> select db name </option>
            <option>database 1</option>
            <option>database 2</option>
        </select>
    </label>
    <br>
    <label><p> Key prefix:</p>
        <select v-model="selectedkeyprefix">
            <option v-for="prefix in keyprefix" :key="prefix">{{ prefix }}</option>
        </select>
    </label>
    <br>
    <label>Key Info: <input v-model="keyinfo"><button @click="search">Search</button></label>

</template>


<style>
* {
  font-size: inherit;
}

input {
  display: block;
  margin-bottom: 10px;
}

select {
  float: left;
  margin: 0 1em 1em 0;
  width: 14em;
}

.buttons {
  clear: both;
}

button + button {
  margin-left: 5px;
}
</style>