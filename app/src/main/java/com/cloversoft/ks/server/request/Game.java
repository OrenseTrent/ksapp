package com.cloversoft.ks.server.request;

import android.content.Context;

import com.cloversoft.ks.R;
import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.config.Url;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.data.model.api.PlayGameModel;
import com.cloversoft.ks.data.model.api.PromotionModel;
import com.cloversoft.ks.data.model.api.UserInfoModel;
import com.cloversoft.ks.data.model.api.UserModel;
import com.cloversoft.ks.vendor.server.request.APIRequest;
import com.cloversoft.ks.vendor.server.request.APIResponse;
import com.cloversoft.ks.vendor.server.transformer.CollectionTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class Game {

    public static Game getDefault(){
        return new Game();
    }

    public void games(Context context, String account,String password,String auth, int gameid) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestPlay(Url.getPlay(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GamePlayResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "play_game")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.PLATFORM, "mobile")
                .addParameter(Keys.GAMEID,gameid)
                .execute();
    }

    public void gameBalance(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalanceResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 102)
                .execute();
    }

    public void gameBalance1(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance1Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 107)
                .execute();
    }

    public void gameBalance2(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance2Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 108)
                .execute();
    }

    public void gameBalance3(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance3Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, null)
                .execute();
    }

    public void gameBalance4(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance4Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 501)
                .execute();
    }

    public void gameBalance5(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance5Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 604)
                .execute();
    }

    public void gameBalance6(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance6Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 106)
                .execute();
    }

    public void gameBalance7(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance7Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 104)
                .execute();
    }

    public void gameBalance8(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance8Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 207)
                .execute();
    }

    public void gameBalance9(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance9Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 201)
                .execute();
    }

    public void gameBalance10(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance10Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 202)
                .execute();
    }


    public void gameBalance11(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance11Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 614)
                .execute();
    }

    public void gameBalance12(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance12Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 402)
                .execute();
    }


    public void gameBalance13(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance13Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, null)
                .execute();
    }

    public void gameBalance14(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance14Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, null)
                .execute();
    }

    public void gameBalance15(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance15Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 613)
                .execute();
    }

    public void gameBalance16(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance16Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 607)
                .execute();
    }

    public void gameBalance17(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance17Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 610)
                .execute();
    }

    public void gameBalance18(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance18Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 603)
                .execute();
    }

    public void gameBalance19(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance19Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 602)
                .execute();
    }

    public void gameBalance20(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance20Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 601)
                .execute();
    }

    public void gameBalance21(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance21Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 609)
                .execute();
    }

    public void gameBalance22(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance22Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 606)
                .execute();
    }

    public void gameBalance23(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance23Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "get_balance")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 605)
                .execute();
    }

    public void quickTransferIn(Context context, String account,String password,String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBal(Url.getCenter(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new GameBalance23Response(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "quick_transfer_in")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.GAMEID, 102)
                .execute();
    }

    public interface RequestService {
        @Multipart
        @POST("{p}")
        Call<SingleTransformer> requestPlay(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("{p}")
        Call<SingleTransformer> requestBal(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);

    }

    public class GamePlayResponse extends APIResponse<SingleTransformer> {
        public GamePlayResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalanceResponse extends APIResponse<SingleTransformer> {
        public GameBalanceResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance1Response extends APIResponse<SingleTransformer> {
        public GameBalance1Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance2Response extends APIResponse<SingleTransformer> {
        public GameBalance2Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance3Response extends APIResponse<SingleTransformer> {
        public GameBalance3Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance4Response extends APIResponse<SingleTransformer> {
        public GameBalance4Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance5Response extends APIResponse<SingleTransformer> {
        public GameBalance5Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance6Response extends APIResponse<SingleTransformer> {
        public GameBalance6Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }


    public class GameBalance7Response extends APIResponse<SingleTransformer> {
        public GameBalance7Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance8Response extends APIResponse<SingleTransformer> {
        public GameBalance8Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance9Response extends APIResponse<SingleTransformer> {
        public GameBalance9Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance10Response extends APIResponse<SingleTransformer> {
        public GameBalance10Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance11Response extends APIResponse<SingleTransformer> {
        public GameBalance11Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance12Response extends APIResponse<SingleTransformer> {
        public GameBalance12Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance13Response extends APIResponse<SingleTransformer> {
        public GameBalance13Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance14Response extends APIResponse<SingleTransformer> {
        public GameBalance14Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance15Response extends APIResponse<SingleTransformer> {
        public GameBalance15Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance16Response extends APIResponse<SingleTransformer> {
        public GameBalance16Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance17Response extends APIResponse<SingleTransformer> {
        public GameBalance17Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance18Response extends APIResponse<SingleTransformer> {
        public GameBalance18Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance19Response extends APIResponse<SingleTransformer> {
        public GameBalance19Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance20Response extends APIResponse<SingleTransformer> {
        public GameBalance20Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance21Response extends APIResponse<SingleTransformer> {
        public GameBalance21Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }
    public class GameBalance22Response extends APIResponse<SingleTransformer> {
        public GameBalance22Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class GameBalance23Response extends APIResponse<SingleTransformer> {
        public GameBalance23Response(APIRequest apiRequest) {
            super(apiRequest);
        }
    }


}
