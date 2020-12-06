<template>
  <Form name="form" @submit="handleRegister">
    <div v-if="!successful">
      <Field
          name="username"
          as="input"
          type="text"
          v-model="user.username"
          :rules="isRequired" />
      <ErrorMessage name="username" />
      <Field
          name="email"
          as="input"
          type="text"
          v-model="user.email"
          :rules="isRequired" />
      <ErrorMessage name="email" />
      <Field
          name="password"
          as="input"
          type="password"
          v-model="user.password"
          :rules="isRequired" />
      <ErrorMessage name="password" />
      <button>Register</button>
    </div>
    <div v-if="message">{{ message }}</div>
  </Form>
</template>

<script>
import { Form, Field, ErrorMessage } from 'vee-validate';
import User from '../models/user';

export default {
  name: 'Register',
  components: {
    Form,
    Field,
    ErrorMessage
  },
  data() {
    return {
      user: new User('', '', ''),
      successful: false,
      message: ''
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.loggedIn;
    }
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push('/profile');
    }
  },
  methods: {
    isRequired(value) {
      return value ? true : 'This field is required';
    },
    handleRegister() {
      this.message = '';
      this.$store.dispatch('auth/register', this.user).then(
          data => {
            this.message = data.message;
            this.successful = true;
          },
          error => {
            this.message = (error.response && error.response.data) || error.message || error.toString();
            this.successful = false;
          }
      );
    }
  }
}
</script>

<style scoped>

</style>
