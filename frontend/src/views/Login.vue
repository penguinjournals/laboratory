<template>
<Form name="form" @submit="handleLogin">
  <Field
      name="username"
      as="input"
      type="text"
      v-model="user.username"
      :rules="isRequired" />
  <ErrorMessage name="username" />
  <Field
      name="password"
      as="input"
      type="password"
      v-model="user.password"
      :rules="isRequired" />
  <ErrorMessage name="password" />
  <button>Login</button>
  <div v-if="message">{{ message }}</div>
</Form>
</template>

<script>
import { Form, Field, ErrorMessage } from 'vee-validate';
import User from '../models/user';

export default {
  name: 'Login',
  components: {
    Form,
    Field,
    ErrorMessage
  },
  data() {
    return {
      user: new User('', ''),
      message: ''
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  created() {
    if(this.loggedIn) {
      this.$router.push('/profile');
    }
  },
  methods: {
    isRequired(value) {
      return value ? true : 'This field is required';
    },
    handleLogin() {
      if (this.user.username && this.user.password) {
        this.$store.dispatch('auth/login', this.user).then(
            () => {
              this.$router.push('/profile');
            },
            error => {
              this.message = (error.response && error.response.data || error.message || error.toString());
            }
        );
      }
    }
  }
}
</script>

<style scoped>

</style>
