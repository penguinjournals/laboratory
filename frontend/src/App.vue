<template>
  <Predictions :predictions=predictions />
</template>

<script>
import axios from 'axios'
import Predictions from "@/components/Predictions";

export default {
  name: 'App',
  components: {
    Predictions
  },
  data() {
    return {
      predictions: []
    }
  },
  created() {
    this.fetchPredictions()
  },
  methods: {
    fetchPredictions () {
      axios.get('api/predictions')
        .then(response => {
          this.predictions = response.data
        })
    }
  }
}
</script>

<style>
</style>
