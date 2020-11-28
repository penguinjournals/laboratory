<template>
  <HelloWorld :msg=greetingMessage />
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import axios from 'axios'

export default {
  name: 'App',
  components: {
    HelloWorld
  },
  data() {
    return {
      greetingMessage: "Client side greeting"
    }
  },
  created() {
    this.fetchGreeting()
  },
  methods: {
    fetchGreeting () {
      axios.get('api/greet')
        .then(response => {
          this.greetingMessage = response.data.greeting
        })
    }
  }
}
</script>

<style>
</style>
