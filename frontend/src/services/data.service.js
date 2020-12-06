import axios from 'axios';
import authHeader from '@/services/auth-header';

const API_URL = 'http://localhost:8181/api/';

class DataService {
  getPredictions() {
    return axios.get(API_URL + 'predictions');
  }

  getProfile() {
    return axios.get(API_URL + 'profile', {headers: authHeader()});
  }
}

export default new DataService();
