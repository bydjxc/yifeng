<template>
  <yf-header></yf-header>
</template>

<script>
import YfHeader from 'components/header/yf-header'
export default {
  name: 'HelloWorld',
  components: {
    YfHeader
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
