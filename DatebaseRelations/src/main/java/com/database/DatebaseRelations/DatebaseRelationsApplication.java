package com.database.DatebaseRelations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatebaseRelationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatebaseRelationsApplication.class, args);
    }

    /**
     * Many to Many ---> 1 Post can have multiple tags and Each tags can have multiple posts
     * One to many --> 1 User can have multiple Comments
     *
     * برای مثال جدول مشخصات فردی و جدول نشانی ها را در نظر بگیرید. هر نشانی تنها به یک شخص اختصاص دارد و هیچ دو فردی وجود ندارند که نشانی مشترک داشته باشند. این نوع ارتباط One to One است
     * one to one --> 1 User have 1 User profile
     */

    /**
     * fetch = FetchType.LAZY
     * میگه فرض کن یه کلاس دانشگاه و یک کلاس دانش دانشجو داری.
     * هر داشنگاه میتونه چندتا دانش آموز داشته باشه.
     * در زمان گرفتن دیتا از دیتابیس اول پراپرتی های دانشگاه رو میگری
     * حالا 2 تا آپشن داری یکی اینکه تمام پراپرتی های (دانشگاه و دانشجو) رو با هم لود کنی میشه eager
     * اما اگه بخوای فقط زمانی که getStudents رو صدا زدی پراپرتی های دانشجو رو بیاره اون وقت میتونی از LAZY استفاده کنی.زمانایی که دیتا زیاده باید از لیزی استفاده کنی
     *
     *
     */


    /**
     * cascade = CascadeType.ALL
     *
     * وقتی از cascade استفاده می‌کنیم که می‌خواهیم به Hibernate اطلاع دهیم, این مقدار را همراه با والد خود ذخیره کند.
     *
     *  for example, the Person–Address relationship. Without the Person,
     *  the Address entity doesn't have any meaning of its own.
     *  When we delete the Person entity, our Address entity should also get deleted.
     *
     * Cascading is the way to achieve this.
     * When we perform some action on the target entity, the same action will be applied to the associated entity.
     *
     * Cascade.ALL propagates all operations — including Hibernate-specific ones — from a parent to a child entity.
     */


    /**
     * خصوصیت mappedBy برای annotation های OneToOne , OneToMany و ManyToMany وجود دارد و مشخص کننده سمتی است که صاحب یک رابطه نیست (non-owning side).
     * در حقیقت mappedBy در کلاس Entity ی که صاحب رابطه نیست (non-owning) تعریف می شود و مقدار آن مشخص می کند متغییری است که از جنس این کلاس در کلاس صاحب رابطه (owning side) تعریف شده است چیست.
     *JoinColumn در کلاس Entity صاحب رابطه تعریف می شود که کلید سمت دیگر رابطه را بعنوان کلید خارجی دارد).
     *وقتی که شما با استفاده از mappedBy سمت صاحب رابطه را مشخص کنید، پس از تغییر در لیست موجود در سمت صاحب رابطه و ذخیره آن تغییرات در هر دو سمت اعمال می شود:
     */






}
