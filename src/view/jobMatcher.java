package view;

import java.util.HashMap;
import java.util.Map;

public class jobMatcher {
    private Map<String, MBTIProfile> mbtiProfiles;

    public jobMatcher() {
        mbtiProfiles = new HashMap<>();
        initializeProfiles();
    }

    private void initializeProfiles() {
        mbtiProfiles.put("ISTJ", new MBTIProfile("ISTJ", "Nhà Thanh tra", 
            "Kế toán, Kỹ sư, Quản lý dự án, Thanh tra viên, Luật sư doanh nghiệp",
            "Tỉ mỉ, logic, đáng tin cậy, tổ chức tốt. Xuất sắc trong việc quản lý chi tiết và đảm bảo tuân thủ quy trình.",
            "Có thể quá cứng nhắc, khó thích nghi với thay đổi. Đôi khi bị xem là khô khan, thiếu sáng tạo."));

        mbtiProfiles.put("ISFJ", new MBTIProfile("ISFJ", "Người Bảo vệ",
            "Y tá, Giáo viên, Nhân viên tư vấn, Nhân viên công tác xã hội, Quản lý chăm sóc khách hàng",
            "Chu đáo, kiên nhẫn, tận tụy. Giỏi chăm sóc và hỗ trợ người khác, đặc biệt trong môi trường cá nhân.",
            "Có thể bị lợi dụng lòng tốt, khó nói \"không\". Đôi khi quá lo lắng về ý kiến của người khác."));

        mbtiProfiles.put("INFJ", new MBTIProfile("INFJ", "Người Cố vấn",
            "Tư vấn tâm lý, Giáo viên, Chuyên gia phát triển cộng đồng, Nhà văn, Nhà thiết kế UX",
            "Trực giác tốt, biết lắng nghe, có tầm nhìn. Xuất sắc trong việc hiểu và hướng dẫn sự phát triển cá nhân.",
            "Có thể bị quá tải cảm xúc, hoàn hảo chủ nghĩa. Đôi khi quá lý tưởng hóa và khó thỏa hiệp."));

        mbtiProfiles.put("INTJ", new MBTIProfile("INTJ", "Nhà chiến lược",
            "Chiến lược gia, Kiến trúc sư, Nhà khoa học, Nhà phân tích tài chính, Giám đốc công nghệ",
            "Tầm nhìn dài hạn, tư duy phê phán tốt, độc lập. Xuất sắc trong việc lập kế hoạch phức tạp và nghiên cứu chuyên sâu.",
            "Có thể bị xem là lạnh lùng, chỉ trích. Đôi khi quá tự tin vào phân tích của mình và bỏ qua ý kiến khác."));

        mbtiProfiles.put("ISTP", new MBTIProfile("ISTP", "Nghệ nhân",
            "Kỹ sư, Phi công, Thợ thủ công, Kỹ thuật viên IT, Bác sĩ phẫu thuật",
            "Thực tế, giải quyết vấn đề tốt, giỏi ứng phó khủng hoảng. Xuất sắc trong các công việc đòi hỏi kỹ năng kỹ thuật và phản ứng nhanh.",
            "Có thể chán nản với lý thuyết, thích hành động hơn lập kế hoạch. Đôi khi bốc đồng và chán với công việc văn phòng."));

        mbtiProfiles.put("ISFP", new MBTIProfile("ISFP", "Nghệ sĩ",
            "Họa sĩ, Nhạc sĩ, Thiết kế đồ họa, Nhà thiết kế thời trang, Chuyên viên làm đẹp",
            "Sáng tạo, nhạy cảm thẩm mỹ, chân thật. Xuất sắc trong việc thể hiện bản thân qua nghệ thuật và thiết kế.",
            "Có thể tránh xung đột, khó quảng bá bản thân. Đôi khi quá chú trọng vào cảm xúc và thiếu kỷ luật."));

        mbtiProfiles.put("INFP", new MBTIProfile("INFP", "Nhà hoạt động lý tưởng",
            "Tác giả, Nhà tâm lý học, Thiết kế UX, Chuyên viên phục hồi chức năng, Nhân viên tư vấn sức khỏe tâm thần",
            "Sáng tạo, đồng cảm, định hướng giá trị. Xuất sắc trong việc hiểu nhu cầu con người và tạo trải nghiệm có ý nghĩa.",
            "Có thể bị choáng ngợp bởi phê bình, thiếu quyết đoán. Đôi khi mơ mộng và khó hoàn thành nhiệm vụ thực tế."));

        mbtiProfiles.put("INTP", new MBTIProfile("INTP", "Nhà sáng tạo logic",
            "Lập trình viên, Nhà nghiên cứu, Phân tích dữ liệu, Nhà toán học, Chiến lược gia",
            "Sáng tạo, logic, ham học hỏi. Xuất sắc trong việc giải quyết các vấn đề phức tạp và phát triển lý thuyết.",
            "Có thể bị mất tập trung, bỏ qua chi tiết nhỏ. Đôi khi quá mải mê với ý tưởng mà quên thực hiện."));

        mbtiProfiles.put("ESTP", new MBTIProfile("ESTP", "Doanh nhân",
            "Môi giới, Quản lý bán hàng, Doanh nhân, Nhà giao dịch chứng khoán, Đại lý bất động sản",
            "Nhanh nhẹn, thực tế, giỏi đàm phán. Xuất sắc trong môi trường cạnh tranh và đòi hỏi sự linh hoạt.",
            "Có thể bốc đồng, chấp nhận rủi ro cao. Đôi khi thiếu kiên nhẫn với lập kế hoạch dài hạn."));

        mbtiProfiles.put("ESFP", new MBTIProfile("ESFP", "Người trình diễn",
            "Diễn viên, Nhà tạo mẫu tóc, Hướng dẫn viên du lịch, Ca sĩ, Chuyên viên quan hệ công chúng",
            "Hấp dẫn, vui vẻ, thích làm việc với người. Xuất sắc trong các vai trò đòi hỏi sự hào hứng và giao tiếp trực tiếp.",
            "Có thể dễ xao nhãng, không thích công việc giấy tờ. Đôi khi quá tập trung vào hiện tại mà quên kế hoạch tương lai."));

        mbtiProfiles.put("ENFP", new MBTIProfile("ENFP", "Nhà vô địch",
            "Nhà báo, Chuyên viên quảng cáo, Huấn luyện viên cuộc sống, Nhà văn sáng tạo, Chuyên viên tuyển dụng",
            "Sáng tạo, nhiệt tình, giỏi nắm bắt cơ hội. Xuất sắc trong việc truyền cảm hứng và kết nối với mọi người.",
            "Có thể quá lạc quan, bỏ dở dự án. Đôi khi khó tập trung vào chi tiết hành chính."));

        mbtiProfiles.put("ENTP", new MBTIProfile("ENTP", "Nhà phát minh",
            "Nhà đổi mới, Nhà phát triển sản phẩm, Doanh nhân công nghệ, Luật sư tranh tụng, Nhà báo điều tra",
            "Sáng tạo, nhanh nhạy, giỏi giải quyết vấn đề. Xuất sắc trong việc phát triển ý tưởng mới và thích ứng nhanh.",
            "Có thể tranh luận quá mức, bỏ qua chi tiết. Đôi khi khó hoàn thành dự án do mải tìm kiếm thử thách mới."));

        mbtiProfiles.put("ESTJ", new MBTIProfile("ESTJ", "Giám sát viên",
            "Quản lý cấp cao, Thẩm phán, Giám đốc tài chính, Quản lý dự án, Giám đốc điều hành",
            "Quyết đoán, có tổ chức, thực tế. Xuất sắc trong việc quản lý và thực hiện kế hoạch phức tạp.",
            "Có thể quá cứng rắn, khó chấp nhận ý kiến khác. Đôi khi bị xem là quá chỉ đạo và thiếu linh hoạt."));

        mbtiProfiles.put("ESFJ", new MBTIProfile("ESFJ", "Người chăm sóc",
            "Giáo viên mầm non, Quản lý nhân sự, Chuyên viên chăm sóc khách hàng, Y tá, Nhân viên sự kiện",
            "Cộng tác tốt, chu đáo, thực tế. Xuất sắc trong việc tạo môi trường hòa hợp và chăm sóc nhu cầu cá nhân.",
            "Có thể quá lo lắng về hình ảnh xã hội, khó đưa ra phản hồi tiêu cực. Đôi khi quá phụ thuộc vào sự đồng ý của người khác."));

        mbtiProfiles.put("ENFJ", new MBTIProfile("ENFJ", "Người dẫn dắt",
            "Lãnh đạo tổ chức, Huấn luyện viên, Giảng viên đại học, Nhà hoạt động xã hội, Nhà ngoại giao",
            "Truyền cảm hứng, đồng cảm, kỹ năng giao tiếp tốt. Xuất sắc trong việc phát triển tiềm năng của người khác.",
            "Có thể quá nhạy cảm với mâu thuẫn, quá cam kết với công việc. Đôi khi cố gắng làm hài lòng mọi người quá mức."));

        mbtiProfiles.put("ENTJ", new MBTIProfile("ENTJ", "Chỉ huy",
            "CEO, Giám đốc điều hành, Cố vấn quản lý, Nhà hoạch định chiến lược, Lãnh đạo chính trị",
            "Định hướng mục tiêu, quyết đoán, tầm nhìn chiến lược. Xuất sắc trong việc lãnh đạo và quản lý dự án lớn.",
            "Có thể quá thống trị, thiếu kiên nhẫn với sự không hiệu quả. Đôi khi bị xem là áp đặt và quá tập trung vào công việc."));
    }


    public MBTIProfile getProfileForMBTI(String mbti) {
        return mbtiProfiles.getOrDefault(mbti.toUpperCase(), 
            new MBTIProfile("Unknown", "Không xác định", 
                "Không có thông tin nghề nghiệp phù hợp",
                "Không có thông tin.",
                "Không có thông tin."));
    }

    public static class MBTIProfile {
        private String code;
        private String title;
        private String jobs;
        private String strengths;
        private String weaknesses;

        public MBTIProfile(String code, String title, String jobs, String strengths, String weaknesses) {
            this.code = code;
            this.title = title;
            this.jobs = jobs;
            this.strengths = strengths;
            this.weaknesses = weaknesses;
        }

        // Getters
        public String getCode() { return code; }
        public String getTitle() { return title; }
        public String getJobs() { return jobs; }
        public String getStrengths() { return strengths; }
        public String getWeaknesses() { return weaknesses; }

        @Override
        public String toString() {
            return String.format("Loại MBTI: %s - %s\n" +
                               "Nghề nghiệp phù hợp: %s\n\n" +
                               "Điểm mạnh:\n%s\n\n" +
                               "Điểm yếu:\n%s",
                               code, title, jobs, strengths, weaknesses);
        }
    }
}