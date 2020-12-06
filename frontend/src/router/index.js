import { createWebHistory, createRouter } from "vue-router";
import Home from '@/views/Home';
import Login from '@/views/Login';
import Register from '@/views/Register';
import Profile from '@/views/Profile';

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/home',
    component: Home
  },
  {
    path: '/signin',
    component: Login
  },
  {
    path: '/signup',
    component: Register
  },
  {
    path: '/profile',
    component: Profile
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
