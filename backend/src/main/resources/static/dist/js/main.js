//import { createApp } from 'vue'
//import App from './App.vue'
//
//import './assets/main.css'
//
//createApp(App).mount('#app')
//<script>

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
//</script>