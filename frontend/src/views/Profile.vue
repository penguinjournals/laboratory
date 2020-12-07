<template>
  {{ currentUser.username }}
  <Form name="form" @submit="registerPrediction">
    <label>Title</label>
    <Field
        name="title"
        as="input"
        type="text"
        placeholder="Title"
        v-model="prediction.title"
        :rules="isRequired" />
    <ErrorMessage name="title" />
    <label>Prediction</label>
    <Field
        name="body"
        as="textarea"
        type="textarea"
        placeholder="Prediction"
        v-model="prediction.body"
        :rules="isRequired" />
    <ErrorMessage name="body" />
    <label>Deadline</label>
    <Field
        name="deadline"
        as="input"
        type="datetime-local"
        v-model="prediction.deadline"
        :rules="isRequired" />
    <ErrorMessage name="deadline" />
    <button>Submit</button>
    <div v-if="success">Prediction saved!</div>
    <div v-if="message">{{ message }}</div>
  </Form>
</template>

<script>
import { Form, Field, ErrorMessage } from 'vee-validate';
import Prediction from '@/models/prediction';

export default {
  name: 'Profile',
  components: {
    Form,
    Field,
    ErrorMessage
  },
  data() {
    return {
      prediction: new Prediction('', '', ''),
      success: false,
      message: ''
    }
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
  },
  methods: {
    isRequired(value) {
      return value ? true : 'This field is required';
    },
    registerPrediction() {
      this.message = '';
      this.$store.dispatch('data/registerPrediction', this.prediction).then(
          data => {
            this.message = data.message;
            this.success = true;
          },
          error => {
            this.message = (error.response && error.response.data) || error.message || error.toString();
            this.success = false;
          }
      );
    }
  }
}
</script>

<style scoped>

</style>
