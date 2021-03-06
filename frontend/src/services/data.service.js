import axios from 'axios';
import authHeader from '@/services/auth-header';

const API_URL = '/api/';

class DataService {
  getPredictions() {
    return axios.get(API_URL + 'predictions');
  }

  getProfile() {
    return axios.get(API_URL + 'profile', {headers: authHeader()});
  }

  postPrediction(prediction) {
    return axios.post(API_URL + 'prediction', prediction, {headers: authHeader()});
  }
}

export default new DataService();
