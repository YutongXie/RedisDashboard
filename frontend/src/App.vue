<script>

export default({
    data() {
        return{
            dbname: '',
            keyprefix: '',
            keyinfo: '',
            selectedkeyprefix: '',
            result: ''
        }
    },
    created() {
        this.fetchKeyPrefix()
    },
    methods: {
        hasValidInput() {
            return this.dbname.trim() && this.selectedkeyprefix.trim() && this.keyinfo.trim()
        },
        async search() {
            if(this.hasValidInput()) {
                const url = '/api/data/getData?keyPrefix='+this.selectedkeyprefix +"&keyInfo=" + this.keyinfo
                this.result = await (await fetch(url)).text()
            } else {
                alert('invalid')
            }
        },
        async fetchKeyPrefix() {
            const url = '/api/data/getkeyprefix?dbname='+this.dbname
            this.keyprefix = await (await fetch(url)).json()
            // this.keyprefix = ['Prefix-1', 'Prefix-2', 'Prefix-3']
        }
    }
})
</script>


<template>
    <span>Name:</span>
    <br>
    <select v-model="dbname" @change="fetchKeyPrefix" >
        <option disabled value=""> select db name </option>
        <option>DB-1</option>
        <option>DB-2</option>
    </select>
    <br>
    <br>
    <span>Key prefix: </span>
    <br>
    <select v-model="selectedkeyprefix">
        <option v-for="prefix in keyprefix" :key="prefix">{{ prefix }}</option>
    </select>
    <br>
    <br>
    <span>Key Info: </span>
    <br>
    <input v-model="keyinfo">
    <br>
    <button @click="search">Search</button>
    <br>
    <br>
    <span>Result:</span>
    <br>
    <textarea v-model="result" placeholder="no result found"></textarea>
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