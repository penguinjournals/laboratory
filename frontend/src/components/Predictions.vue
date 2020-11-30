<template>
<ul>
  <li v-for="prediction in predictions" v-bind:key="prediction">
    <Prediction :prediction=prediction></Prediction>
  </li>
</ul>
</template>

<script>
import Prediction from "@/components/Prediction";
export default {
  name: "Predictions",
  components: {
    Prediction
  },
  props: {
    predictions: Array
  }
}
</script>

<style scoped>

</style>
