<template>
<Predictions :predictions="predictions" />
<div v-if="errror">Something went wrong :(</div>
</template>

<script>
import DataService from '@/services/data.service';
import Predictions from '@/components/Predictions';

export default {
  name: 'Home',
  components: {
    Predictions
  },
  data() {
    return {
      predictions: '',
      error: false
    }
  },
  mounted() {
    DataService.getPredictions().then(
        response => {
          this.predictions = response.data;
        },
        error => {
          this.content = (error.response && error.response.data) || error.message || error.toString();
        }
    );
  }
}
</script>

<style scoped>

</style>
