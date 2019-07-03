package jms;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import jms.entity.UserEntity;
import jms.entity.enumeration.Role;
import jms.repostory.UserEntityRepository;





@SpringBootApplication
public class SpringBootConsulttionTestProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootConsulttionTestProjectApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootConsulttionTestProjectApplication.class, args);
	addAdmin(context);
	//addStorageProduct(context);
		
	}
	
	static void addAdmin(ConfigurableApplicationContext context) {

		String email = "ib";
		String nameUser = "ADMIN";
		String password = "1";
		
		UserEntityRepository customerRepository = context.getBean(UserEntityRepository.class);
		UserEntity userEntity = customerRepository.findUserByEmail(email);
		if(userEntity == null) {
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			userEntity = new UserEntity();

			userEntity.setEmail(email);
			userEntity.setNameUser(nameUser);
			userEntity.setPassword(encoder.encode(password));
			userEntity.setActivated(true);
			userEntity.setRole(Role.ROLE_ADMIN);
			
			customerRepository.save(userEntity);
			
		
			
		}
	}
	
	/*static void addStorageProduct(ConfigurableApplicationContext context) {
		
		StorageProductRepository storageProductRepository = context.getBean(StorageProductRepository.class);
		StorageProduct sp = storageProductRepository.findOne((long) 1);
		
		if(sp == null) {
			storageProductRepository.save(getStorageProduct());
		}
	}
	
		 private static List<StorageProduct> getStorageProduct(){
			 List<StorageProduct> sp = new ArrayList<>();
				BigDecimal bigDecimal = new BigDecimal(12);
				Date date = new Date();*/
				
			/*	sp.setNameProduct("wheel");
				sp.setQuantity(2);
				sp.setPrice(bigDecimal);
				sp.setManufacture(Manufacture.Audi);
				storageProductRepository.save(sp);	*/
			/*	sp.add(new StorageProduct("wheel", 2, bigDecimal, Manufacture.Audi, date, null));
				return sp;

	}*/
	/*static void addUser(ConfigurableApplicationContext context) {
		CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
		Customer user = customerRepository.findOne((long) 1);
		
		if(user == null) {
			customerRepository.save(getUser());
		}
		
	}
	
	private static List<Customer> getUser(){
		List<Customer> user = new ArrayList<>();
		
		user.add(new Customer("Vito", 6764, "1111", Role.ROLE_USER, null, null ));
	
		
		
		return user;
	}
	
	
	static void addSticker(ConfigurableApplicationContext context) {
		StickerRepository stickerRepository = context.getBean(StickerRepository.class);
		Sticker carentity = stickerRepository.findOne(1);
		
		if(carentity == null) {
			stickerRepository.save(getStickers());
		}
		
	}
	
	private static List<Sticker> getStickers(){
		List<Sticker> sticker = new ArrayList<>();
		
		for(int i =0; i<50; i++) {
		sticker.add(new Sticker("BMW"+ i,null , StickerType.Holo, AboutSticker.Car, null, null));
		}
		
		
		return sticker;
	}*/

}