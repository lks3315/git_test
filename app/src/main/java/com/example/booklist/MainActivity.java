package com.example.booklist;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.booklist.adapter.BookAdapter;
import com.example.booklist.intentActivity.ContentActivity;
import com.example.booklist.model.Book;

import java.util.ArrayList;
import java.util.List;

// listView의 사용을 위한 인터페이스 상속
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    List<Book> list; //Beans에 대한 데이터 저장위한 list
    BookAdapter adapter; // ListView와 List를 연결하는 어댑터
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Book>();
        adapter = new BookAdapter(this, R.layout.list_item,list);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        //데이터 추가
        addData();
    }

    private void addData() {
        String story = "염상진:남로당 보성군당 군당위원장이자 좌파이다. 일제강점기때부터 적색농민운동을 " +
                "주도했을 정도로, 공산주의 사회 건설에 열정을 갖고 있으며 자신의 신념을 지키기 위해 죽음을 택하며" +
                " 1953년 휴전 협정 후 일어난 대규모 빨치산 토벌로 더이상 활동하지 못하게 되자,대원들과 함께 " +
                "수류탄으로 자결함으로써 사상의 기백을 지킨다. 영화에서는 배우 김명곤이 염상진 역을 맡아 " +
                "냉철한 캐릭터를 드러냈다.\n" +
                "염상구:염상진의 동생. 아버지의 노골적인 편애때문에, 형을 미워하여 극우성향을 띤 건달패이다. " +
                "그래도 형이 죽은후 목이 내걸려 경찰의 민중들에 대한 말없는 협박에 이용되자, 건달조직의 동생들을 " +
                "이끌고 시위해서 시체를 거둔다. 영화에서는 연극배우인 김갑수가 염상구 역을 맡아 불량한 캐릭터를 " +
                "싸늘하고 삐딱한 말투로 묘사하였다.\n" +
                "염무칠, 호산댁:염상진과 염상구의 부모이다. 염무칠은 전혀 가진 것이 없었지만, 젊은 사람이 열심히 " +
                "살려고 하는 모습에 감탄한 숯 도매상과 선암사 주지 스님의 배려로 숯장사를 시작하였다. 곰같은 " +
                "염서방이라고 불릴 만큼 억척스럽게 일한 덕분에 큰아들 염상진을 사범학교에 진학시키지만, " +
                "사회주의 농민운동에 가담한 큰아들의 진로선택에 충격받아서 죽었다. 작은아들 염상구도 형만 " +
                "예뻐하는 아버지의 편애에 대한 상처가 커서 건달패가 되었다. 그래서 사람들은 염서방을 두 아들이 " +
                "잡아먹었다고 수군거린다. 호산댁도 자식들때문에 고생하기는 마찬가지. 모성애가 지극한 호산댁은 " +
                "서로 미워하는 두 아들을 보면서 마음 아파한다. 염무칠이 가족을 위해 희생하는 보편적인 아버지의 " +
                "모습을 보인다면, 호산댁은 자녀가 잘났던, 못났던 차별없이 사랑하는 모성애를 보인다.\n" +
                "죽산댁:염상진의 아내이다. 여성가장인 그녀는 자신이 없으면, 아이들을 돌볼 사람이 없는 현실을 " +
                "너무나도 잘 안다. 그래서 \"군당위원장님의 부인께서 여성민주동맹(여맹)에 가입하지 " +
                "않으시다니요.\"라며 설득하려는 이지숙에게 \"부부가 공산주의 운동에 같이 미치면 집구석은 " +
                "누가 돌보겄소?\"라며 물리치고 여성민주동맹(여맹)에 가입하지 않는다. 고집이 센 이지숙은 꼭 " +
                "설득하고 싶어하지만, \"그분의 뜻이 그렇다면 강요하면 안 됩니다.\"라는 안창민의 설득으로 더이상 " +
                "여맹가입을 요구하지 않는다. 영화에서는 연극배우 정경순이 죽산댁 역을 맡았다.\n" +
                "광조, 덕순:염상진의 자녀들이다. 광조는 자신의 사상을 헌신적으로 실천하는 아버지를 존경하여, " +
                "커서 어른이 되면 아버지같은 사내 대장부가 되기를 바라고 있다. 덕순은 일하느라 바쁜 어머니를 " +
                "대신하여 동생을 잘 돌보는 속깊은 누나이다. 그래서 죽산댁은 아버지의 사랑을 받지 못했는데도 " +
                "삐뚤어지지 않고 잘 자라는 덕순과 광조를 보면서 속으로 미안해한다. 빨치산 활동을 하느라 가정을" +
                " 돌보지 않는 아버지의 무책임한 모습을 보고 자란 덕순은 아버지같은 사람이 되려고 하는 동생 광조를" +
                " 보면 불안하기 그지 없다.";
        adapter.add(new Book("안드로이드: 플랫폼 포팅과 활용",
                "전용준 김한철 외 2 명 지음", "진한엠앤비 펴냄", story, R.mipmap.book01));
        adapter.add(new Book("안드로이드 프로그래밍",
                "천인국 지음", "생능출판사 펴냄", story, R.mipmap.book02));
        adapter.add(new Book("안드로이드 앱 프로그래밍",
                "정재곤 지음", "이지스퍼블리싱 펴냄", story, R.mipmap.book03));
        adapter.add(new Book("안드로이드 프로그래밍 정복. 1",
                "김상형 지음", "한빛미디어 펴냄", story, R.mipmap.book04));
        adapter.add(new Book("안드로이드 프로그래밍 정복. 2",
                "김상형 지음", "한빛미디어 펴냄", story, R.mipmap.book05));
        adapter.add(new Book("아두이노와 안드로이드로 45개 프로젝트 만들기",
                "서민우 지음", "앤써북 펴냄", story, R.mipmap.book06));
        adapter.add(new Book("안드로이드 프로그래밍",
                "장용식 성낙현 지음", "인피니티북스 펴냄", story, R.mipmap.book07));
        adapter.add(new Book("안드로이드는 전기양을 꿈꾸는가",
                "필립 K. 딕 지음 / 이선주 옮김", "황금가지 펴냄", story, R.mipmap.book08));
        adapter.add(new Book("안드로이드 스마트폰 베스트 앱 200",
                "이동규 지음", "정보문화사 펴냄", story, R.mipmap.book09));
        adapter.add(new Book("안드로이드를 지배하는 통신 프로그래밍",
                "박헌재 지음", "프리렉 펴냄", story, R.mipmap.book10));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ContentActivity.class );
        Book item = adapter.getItem(position);
        String subject = item.getSubject();
        String writer = item.getWriter();
        String publisher = item.getPublisher();
        String story = item.getStroy();
        int image = item.getImage();

        Book book = new Book(subject,writer,publisher,story,image);
        intent.putExtra("book", book);
        switch (parent.getId()) {
            case R.id.listView:
                startActivity(intent);
                break;
        }
//        switch (parent.getId()) {
//            case R.id.listView:
//                Book item = adapter.getItem(position);
//                Toast.makeText(this,item.getSubject(),Toast.LENGTH_SHORT).show();
//                break;
//        }
    }
}
