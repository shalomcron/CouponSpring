package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByName(String name);

    boolean existsByEmail(String name);

    Optional<Company> findByEmailAndPassword(String email, String password);

/*
        @Override
        public void add(Coupon coupon) throws JDBCException {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1, coupon.getCompanyId());
            params.put(2, coupon.getCategoryId());
            params.put(3, coupon.getTitle());
            params.put(4, coupon.getDescription());
            params.put(5, coupon.getStartDate());
            params.put(6, coupon.getEndDate());
            params.put(7, coupon.getAmount());
            params.put(8, coupon.getPrice());
            params.put(9, coupon.getImage());
            JDBCUtils.executeQuery(QUERY_INSERT, params);
        }

        @Override
        public List<Coupon> getAll() throws JDBCException {
            List<Coupon> results = new ArrayList<>();
            List<Map<String, Object>> rows = JDBCUtils.executeQueryWithResults(QUERY_GET_ALL);
            for (Map<String, Object> object : rows) {
                results.add(ResultsUtils.couponFromRow(object));
            }
            return results;
        }

        @Override
        public List<Coupon> getAllCompanyCoupons(int companyId) throws JDBCException {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1, companyId);
            List<Coupon> results = new ArrayList<>();
            List<Map<String, Object>> rows = JDBCUtils.executeQueryWithResults(QUERY_GET_COMPANY_COUPONS, params);
            for (Map<String, Object> object : rows) {
                results.add(ResultsUtils.couponFromRow(object));
            }
            return results;
        }

        @Override
        public List<Coupon> getAllCompanyCoupons(int companyId, int categoryId) throws JDBCException {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1, companyId);
            params.put(2, categoryId);
            List<Coupon> results = new ArrayList<>();
            List<Map<String, Object>> rows = JDBCUtils.executeQueryWithResults(QUERY_GET_COMPANY_COUPONS_CATEGORY, params);
            for (Map<String, Object> object : rows) {
                results.add(ResultsUtils.couponFromRow(object));
            }
            return results;
        }

        @Override
        public List<Coupon> getAllCompanyCoupons(int companyId, double maxPrice) throws JDBCException {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1, companyId);
            params.put(2, maxPrice);
            List<Coupon> results = new ArrayList<>();
            List<Map<String, Object>> rows = JDBCUtils.executeQueryWithResults(QUERY_GET_COMPANY_COUPONS_MAX_PRICE, params);
            for (Map<String, Object> object : rows) {
                results.add(ResultsUtils.couponFromRow(object));
            }
            return results;
        }

        @Override
        public Coupon getSingle(Integer id) throws JDBCException {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1, id);
            List<Map<String, Object>> rows = JDBCUtils.executeQueryWithResults(QUERY_GET_ONE, params);
            return rows.size() > 0 ? ResultsUtils.couponFromRow(rows.get(0)): null;
        }

        @Override
        public void update(Integer id, Coupon coupon) throws JDBCException {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1, coupon.getCompanyId());
            params.put(2, coupon.getCategoryId());
            params.put(3, coupon.getTitle());
            params.put(4, coupon.getDescription());
            params.put(5, coupon.getStartDate());
            params.put(6, coupon.getEndDate());
            params.put(7, coupon.getAmount());
            params.put(8, coupon.getPrice());
            params.put(9, coupon.getImage());
            params.put(10, id);
            JDBCUtils.executeQuery(QUERY_UPDATE, params);
        }

        @Override
        public void delete(Integer id) throws JDBCException {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1, id);
            JDBCUtils.executeQuery(QUERY_DELETE, params);
        }

        @Override
        public boolean isExistByTitle(int companyId, String title) throws JDBCException {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1, companyId);
            params.put(2, title);
            return ResultsUtils.isExistFromRow(JDBCUtils.executeQueryWithResults(QUERY_IS_EXIST_BY_TITLE, params).get(0));
        }

    }
*/
}

/*
    public class CouponDAOImpl implements CouponDAO {
        private static final CouponDAOImpl instance = new CouponDAOImpl();

        private static final String QUERY_INSERT = "INSERT INTO `coupone-bhp-386`.`coupons` " +
                "(`ID_COMPANY`, `ID_CATEGORY`, `TITLE`, `DESCRIPTION`, `DATE_START`, `DATE_END`, `AMOUNT`, `PRICE`, `IMAGE`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        private static final String QUERY_GET_ALL = "SELECT * FROM `coupone-bhp-386`.coupons";
        private static final String QUERY_GET_COMPANY_COUPONS = "SELECT * FROM `coupone-bhp-386`.coupons " +
                "WHERE (ID_COMPANY = ?) ORDER BY ID";
        private static final String QUERY_GET_COMPANY_COUPONS_CATEGORY = "SELECT * FROM `coupone-bhp-386`.coupons " +
                "WHERE (ID_COMPANY = ? AND ID_CATEGORY = ?) ORDER BY ID";
        private static final String QUERY_GET_COMPANY_COUPONS_MAX_PRICE = "SELECT * FROM `coupone-bhp-386`.coupons " +
                "WHERE (ID_COMPANY = ? AND PRICE <= ?) ORDER BY ID";
        private static final String QUERY_GET_ONE = "SELECT * FROM `coupone-bhp-386`.coupons WHERE id=?";

        private static final String QUERY_UPDATE = "UPDATE `coupone-bhp-386`.`coupons` " +
                "SET `ID_COMPANY` = ?, `ID_CATEGORY` = ?, `TITLE` = ?, `DESCRIPTION` = ?, " +
                "`DATE_START` = ?, `DATE_END` = ?, `AMOUNT` = ?, `PRICE` = ?, `IMAGE` = ? WHERE (`ID` = ?);";
        private static final String QUERY_DELETE = "DELETE FROM `coupone-bhp-386`.`coupons` WHERE (`ID` = ?)";

        private static final String QUERY_IS_EXIST_BY_TITLE = "select exists (SELECT * FROM `coupone-bhp-386`.coupons " +
                "WHERE (`ID_COMPANY` = ? and `TITLE` = ?) ) as RES;";


        private CouponDAOImpl() {}

        public static CouponDAOImpl getInstance() {
            return instance;
        }


 */