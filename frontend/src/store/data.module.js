import DataService from '@/services/data.service'

export const data = {
  namespaced: true,
  state: {
    predictions: []
  },
  actions: {
    registerPrediction({commit}, prediction) {
      return DataService.postPrediction(prediction).then(
        prediction => {
          commit('postSuccess', prediction);
          return Promise.resolve(prediction);
        },
        error => {
          return Promise.reject(error);
        }
      );
    }
  },
  mutations: {
    postSuccess(state, prediction) {
      state.predictions.push(prediction);
    }
  }
}
