<template>
  <div id="app">
    <router-link to="/">Home</router-link>
    <div v-if="!currentUser">
      <router-link to="/signin">Login</router-link>
      <router-link to="/signup">Register</router-link>
    </div>
    <div v-if="currentUser">
      <router-link to="/profile">Profile</router-link>
      <a href @click.prevent="logout">Logout</a>
    </div>
    <div>
      <router-view />
    </div>
  </div>
</template>

<script>

export default {
  name: 'App',
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  methods: {
    logout() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/');
    }
  }
}
</script>

<style>
</style>
