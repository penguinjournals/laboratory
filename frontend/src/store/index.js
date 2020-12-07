import Vuex from 'vuex';

import { auth } from '@/store/auth.module';
import { data} from '@/store/data.module';

export default new Vuex.Store({
  modules: {
    auth,
    data
  }
});
