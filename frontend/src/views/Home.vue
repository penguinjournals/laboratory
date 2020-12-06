<template>
{{ content }}
</template>

<script>
import DataService from '../services/data.service'
export default {
  name: 'Home',
  data() {
    return {
      content: ''
    }
  },
  mounted() {
    DataService.getPredictions().then(
        response => {
          this.content = response.data;
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
