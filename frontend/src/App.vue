<template>
  <HelloWorld :msg=greetingMessage />
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  },
  data() {
    return {
      greetingMessage: "Holi"
    }
  }
}
</script>

<style>
</style>
