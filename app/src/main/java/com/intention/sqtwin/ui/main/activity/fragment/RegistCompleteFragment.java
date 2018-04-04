package com.intention.sqtwin.ui.main.activity.fragment;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.widget.ClearEditText;

import butterknife.BindView;

/**
 * Description:
 * Data：2017/9/14 0014-下午 17:51
 * Blog：Super简单
 * Author: ZhhouYong
 */

public class RegistCompleteFragment extends BaseFragment {
    @BindView(R.id.iv_household)
    ImageView ivHousehold;
    @BindView(R.id.user_houlseId)
    TextView Tv_user_houlseId;
    //户口所在地
    @BindView(R.id.Account_id)
    RelativeLayout AccountId;
    @BindView(R.id.iv_name)
    ImageView ivName;
    @BindView(R.id.Name)
    ClearEditText Name;
    @BindView(R.id.Name_id)
    RelativeLayout NameId;
    //    @BindView(R.id.iv_sex)
//    ImageView ivSex;
    @BindView(R.id.tv_man)
    TextView Tv_man;
    @BindView(R.id.tv_woman)
    TextView Tv_woman;
    //    @BindView(R.id.Rg_sex)
//    LinearLayout RgSex;
//    @BindView(R.id.Sex_id)
//    RelativeLayout SexId;
    @BindView(R.id.iv_invite)
    ImageView ivInvite;
    @BindView(R.id.Invitation)
    ClearEditText Invitation;
    @BindView(R.id.Invitation_id)
    RelativeLayout InvitationId;
    @BindView(R.id.before_agreement)
    TextView beforeAgreement;
    @BindView(R.id.forget_rel)
    RelativeLayout forgetRel;
    // 选择学校的地址
    @BindView(R.id.user_schoolareaId)
    TextView userSchoolareaId;
    //学校名字
    @BindView(R.id.user_schoolId)
    TextView userSchoolId;
    //年级
    @BindView(R.id.user_grade)
    TextView userGrade;
    @BindView(R.id.user_class)
    ClearEditText Etclassname;
   /* @BindView(R.id.iv_exam_type)
    ImageView iv_exam_type;*/
   /* @BindView(R.id.user_exam_type)
    TextView user_exam_type;*/

    private final int RequestCode = 101;

    private final int RequestSchoolId = 102;
    // 户口所在地名字
    public String user_Account;
    // 户口所在地的Id
    private int user_AccountId;
    // 性别
    public int user_sex;
//    private PostRegistInfo postRegistInfo;
    // 真实姓名
    private String user_name;
    // 邀请码
    private String Invitation_code;
    // 年级
    private String grade = "1";
    //班级名称
    private String classname;
    // 全部地址

    private String SchoolId;
    private boolean gradeSchool;
//    private ArrayList<String> typeList = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_regist_complete;
    }

    public static RegistCompleteFragment newInstance() {
        return new RegistCompleteFragment();
    }

    @Override
    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {

    }


}
