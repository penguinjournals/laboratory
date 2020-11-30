<template>
  <div>Title: {{ prediction.title }} ({{ prediction.id }})</div>
  <div>Prediction: {{ prediction.body }}</div>
  <div>Deadline: {{ prediction.deadline }}</div>
</template>

<script>
export default {
  name: "Prediction",
  props: {
    prediction: {}
  }
}
</script>

<style scoped>

</style>
