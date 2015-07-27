package skk.pak.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView selectedImage;
	TextView tv_name;
	TextView tv_description;
	static Integer[] mImageIds = { R.drawable.muhammad_ali_jinnah,
			R.drawable.khawaja_nazimuddin, R.drawable.malik_ghulam_muhammad,
			R.drawable.iskander_mirza, R.drawable.muhammad_ayub_khan,
			R.drawable.yahya_khan, R.drawable.zulfikar_ali_bhutto,
			R.drawable.fazal_ilahi_chaudri, R.drawable.muhammad_zia_ul_haq,
			R.drawable.ghulam_ishaq_khan, R.drawable.wasim_sajjad,
			R.drawable.farooq_leghari, R.drawable.muhammad_rafiq_tarard,
			R.drawable.pervez_musharraf, R.drawable.somro,
			R.drawable.asif_ali_zardari, R.drawable.mamnun_husain };

	private String leadersNames[] = { "Muhammad Ali Jinnah (1876–1948)",
			"Sir Khawaja Nazimuddin (1894–1964)",
			"Malik Ghulam Muhammad (1895–1956)",
			"Major-General Iskander Mirza (1899–1969)",
			"Field Marshal Ayub Khan (1907–1974)",
			"General Yahya Khan (1907–1974)",
			"Zulfikar Ali Bhutto (1928–1979)",
			"Fazal Ilahi Chaudhry(1904–1982)",
			"General Muhammad Zia-ul-Haq (1924–1988)",
			"Ghulam Ishaq Khan (1915–2006)", "Wasim Sajjad (1941–)",
			"Farooq Leghari (1940–2010)", "Muhammad Rafiq Tarar (1929–)",
			"General Pervez Musharraf (1943–)", "Muhammad Mian Soomro (1950–)",
			"Asif Ali Zardari (1955–)", "Mamnoon Hussain(1940–)" };
	private String descript[] = {
			"Muhammad Ali Jinnah (born 25 December 1876 – 11 September 1948) was a lawyer, politician, and the founder of "
					+ "Pakistan.Jinnah served as leader of the All-India Muslim League from 1913 until Pakistan's independence on"
					+ " 14 August 1947, and as Pakistan's first Governor-General from independence until his death. He is revered "
					+ "in"
					+ " Pakistan as Quaid-i-Azam Urdu: قائد اعظم‎ (Great Leader) and Baba-i-Qaum Urdu: بابائے قوم‎ (Father of the Nation). His "
					+ "birthday is observed as a national holiday. Born in Karachi and trained as a barrister at Lincoln's Inn in "
					+ "London.",
			"Sir Khawaja Nazimuddin (19 July 1894 – 22 October 1964) was a east pakistani politician and statesman from the"
					+ " Dhaka Nawab Family. A member of the All India Muslim League, Nazimuddin served as the second Prime Minister"
					+ " of Bengal in the British Raj. After the establishment of Pakistan, he became the second Governor-General of"
					+ " Pakistan in 1948, following the death of Muhammad Ali Jinnah. After the assassination of Prime Minister"
					+ " Liaquat Ali Khan in 1951, Nazimuddin assumed office as the second Prime Minister of Pakistan.[1] A staunch "
					+ "conservative, he was an often unpopular political figure. His government lasted only two years, but saw civil"
					+ " unrest and foreign challenges that led to their final dismissal.",
			"Malik Ghulam Muhammad 20 April 1895 – 12 September 1956) was a Pakistani civil servant who served as the third"
					+ " Governor-General of Pakistan from October 1951 until his dismissal in August 1955. He previously served as"
					+ " the country's first Finance Minister in the cabinet of Prime Minister Liaquat Ali Khan. Educated at Aligarh"
					+ " Muslim University,[1] Ghulam Muhammad worked as a chartered accountant before joining the Indian Railway "
					+ "Services as an auditor for India's Finance Ministry. He opted for Pakistan following Partition, and was "
					+ "appointed the new country's first Finance Minister. He drafted Five-Year Plans for the economy in 1948,"
					+ " based on the Soviet model, but was unable to implement them. He also organized the International Islamic"
					+ " Economic Conference held in 1949, and called for forming a pan-Islamic economic bloc.Appointed "
					+ "Governor-General by Prime Minister Khwaja Nazimuddin in 1951, he grappled unsuccessfully with the Kashmir "
					+ "dispute with India and unrest in East Pakistan. Following anti-Ahmadi riots in Lahore in 1953, he declared "
					+ "martial law in the city under Lieutenant General Azam Khan. After the army quelled the riots, "
					+ "Ghulam Muhammad"
					+ " sacked Nazimuddin's government, helping Muhammad Ali Bogra replace him as Prime Minister. When "
					+ "Bogra attempted to lessen the powers of the Governor-General's office via parliament, Ghulam Muhammad "
					+ "dismissed the Constituent Assembly as well in 1954. Affected by paralysis, he took a leave of illness "
					+ "in 1955, and was himself dismissed by acting Governor-General Iskander Mirza.",
			"Major General Sahibzada Sayyid Iskander Ali Mirza (November 13, 1899 – November 13, 1969), was the first "
					+ "President of Pakistan, serving from 1956 to 1958. Prior to that, Mirza was the last Governor-General of "
					+ "Pakistan from 1955 to 1956.[1] A great grandson of Mir Jafar,[2] Mirza was a career army officer, having "
					+ "reached the higher rank of major-general in Pakistan Army.After a brief stint in the British Indian Army, "
					+ "Mirza joined the Indian Political Service. He became the Joint Defence Secretary of India in 1946. After "
					+ "the establishment of Pakistan in 1947, Prime minister Liaquat Ali Khan appointed Mirza as the first Defence"
					+ " Secretary, one of the most important government positions. He oversaw the Indo-Pakistan war of 1947, and"
					+ " the Balochistan conflict in 1948.Serious disorder and civil unrest sparked in East Pakistan as a result "
					+ "of the Bengali Language Movement in 1952, prompting Prime minister Khawaja Nazimuddin to appoint him as the"
					+ " Governor of the province. He oversaw the success of the One Unit programme in East Pakistan in 1954, and "
					+ "succeeded Malik Ghulam Muhammad as the governor general in 1955. After successfully promulgating the 1956 "
					+ "constitution, he became the first president. His presidency saw great political instability, challenges in "
					+ "foreign policy, and the ouster of four prime ministers in two years. He finally imposed martial law in 1958 "
					+ "after suspending the constitution and dissolving democratic institutions, including the Pakistan Parliament."
					+ " Mirza has the distinction of being the first to bring in military influence in national politics after he"
					+ " appointed his army chief as chief martial law administrator of the country. ",
			"Muhammad Ayub Khan (14 May 1907 –19 April 1974), widely known as Ayub Khan, was the first military dictator "
					+ "and second President of Pakistan. He assumed power in the 1958 Pakistani coup d'état, serving in office "
					+ "until"
					+ " his forced resignation amid a popular uprising in 1969. Trained at Sandhurst, Ayub Khan fought in World War"

					+ " II as an officer in the British Indian Army. He joined the armed forces of the newly formed state of "
					+ "Pakistan upon independence in 1947, and became its chief military commander in East Bengal. "
					+ "He was appointed "
					+ "as the first native Commander-in-Chief of the Pakistan Army in 1951 by the then-Prime Minister "
					+ "Liaquat Ali Khan,[2] in a controversial promotion over several senior officers. President Iskander Mirza's "
					+ "decision to declare martial law in 1958 was supported by Ayub, whom Mirza declared chief martial law "
					+ "administrator.[3] Two weeks later, Ayub deposed Mirza in a bloodless coup and assumed the presidency. "
					+ "He relinquished the post of army chief to General Musa Khan the same year.Ayub continued his predecessors' "
					+ "policy of an alliance with the United States during the Cold War, joining CENTO, and allowing the U.S. "
					+ "and Britain access to facilities inside Pakistan, most notably the airbase outside of Peshawar, from which "
					+ "U-2 intelligence flights over the Soviet Union were launched. He also strengthened military ties with "
					+ "neighboring China, while relations deteriorated with the Soviet Union and India. There was the five-week war"
					+ " in 1965 with India, ending in a United Nations-mandated ceasefire. Domestically, Ayub embraced "
					+ "private-sector industrialization and free-market principles, making the country one of Asia's"
					+ " fastest-growing economies. He built several infrastructure projects, including canals, dams and power "
					+ "stations, began Pakistan's space programme, and gave less priority to nuclear deterrence.",
			"Agha Muhammad Yahya Khan (4 February 1917 – 10 August 1980), was a Pakistani general who served as the 3rd"
					+ " President of Pakistan from 1969 until East Pakistan's secession to Bangladesh in 1971, and Pakistan's "
					+ "defeat in the Indo-Pakistani war of the same year.Serving with distinction in World War II as a British "
					+ "Indian Army officer, Yahya opted for Pakistan in 1947 and became one of the earliest senior local officers "
					+ ""
					+ "in its army. After helping conduct Operation Grand Slam during the Indo-Pakistani war of 1965, Yahya was "
					+ "made the army's Commander-in-Chief in 1966. Appointed to succeed him by outgoing president Ayub Khan in 1969,"
					+ " Yahya dissolved the government and declared martial law for the second time in Pakistan's history. He "
					+ "held the country's first free and fair elections in 1970, which saw Sheikh Mujibur Rahman's Awami League "
					+ "party in East Pakistan win the majority vote. Pressured by Zulfikar Ali Bhutto, whose party had won in West"
					+ " Pakistan but had far less votes, Yahya delayed handing over power to Mujib. As civil unrest erupted all over"
					+ " East Pakistan, Yahya initiated Operation Searchlight to quell the rebellion",
			"Zulfikar Ali Bhutto (5 January 1928 – 4 April 1979) was the ninth Prime Minister of Pakistan (1973–77) "
					+ "and its fourth President (1971–73). Revered as Quaid-i-Awam (Urdu:قا ئد عوام; lit. People's Leader),"
					+ " he founded the Pakistan People's Party (PPP) and served as its chairman until his execution in 1979."
					+ "Educated at USC, UC Berkeley and Oxford, Bhutto trained as a barrister at Lincoln's Inn in London."
					+ " His political career began as a member of President Iskander Mirza's cabinet, before being assigned to "
					+ "several ministries during the presidency of Field Marshal Ayub Khan from 1958. Appointed as Foreign Minister"
					+ " "
					+ "in 1963, Bhutto was a proponent of covert infiltration in Indian Kashmir, leading to war with India in 1965."
					+ " An agreement brokered by the Soviet Union ended hostilities, but Bhutto fell out with Ayub and was dismissed"
					+ " from the government. After uniting the left, Bhutto founded the PPP in 1967, and contested the 1970 general"
					+ " election held by President Yahya Khan – Ayub's successor. Although the East Pakistani party, the Awami "
					+ "League, won a suprising plurality of seats, the results were declared as unsatisfactory by Bhutto's party"
					+ " and the League's leader, Sheikh Mujibur Rahman, was placed under arrest on March 25, 1971. A massive "
					+ "military crackdown in East Pakistan ensued, culminating in the slaughter of 3,000,000 of its citizens "
					+ "(1971 Bangladesh genocide) and an additional ten million being forced to flee to India as refugees."
					+ "Subsequent Indian armed intervention on Bangladesh/East Pakistan's behalf (Indo-Pakistani war of 1971) "
					+ "resulted in the surrender of all West Pakistani forces in the region by December 16, 1971. General Yahya"
					+ " Khan relinquished power to Bhutto on December 20 and on July 2, 1972, President Bhutto signed the Simla "
					+ "Agreement with India, extending full diplomatic recognition to Bangladesh in 1974. Bhutto also strengthened"
					+ " his country's ties with the Soviet Union, the People's Republic of China and Saudi Arabia. Domestically,"
					+ " Bhutto's reign saw parliament unanimously approve a new constitution in 1973, after which he endorsed Fazal"
					+ " Ilahi's bid for president, and assumed instead the newly empowered office of Prime minister. He also played"
					+ " an integral role in initiating the atomic–bomb programme. His economic programme was based on the "
					+ "nationalization of much of Pakistan's fledgling industries, healthcare, and educational institutions. "
					+ "In an attempt to restore peace, Bhutto dissolved the Balochistan Assembly which was met with unrest;"
					+ " Bhutto subsequently ordered a military operation in the province in 1973.Despite civil disorder,"
					+ " aggravated by incidents of repression by federal forces, the PPP won the 1977 parliamentary "
					+ "elections easily. However, a conservative alliance alleged widespread rigging, and violence escalated "
					+ "across Pakistan. Finally on 5 July 1977, chief of army staff General Zia-ul-Haq deposed Bhutto in a"
					+ " bloodless coup, and had the former Prime Minister controversially tried and executed by the Supreme "
					+ "Court in 1979 for authorising the murder of a political opponent. While Bhutto's legacy is contentious, "
					+ "his party, the PPP, remains one of the largest in Pakistan and continues to be dominated by members of"
					+ " his family.",
			"Fazal Ilahi Chaudhry (January 1, 1904 – June 2, 1982), was the fifth President of Pakistan, serving from "
					+ "1973 until 1978, prior to the martial law led by Chief of Army Staff General Zia-ul-Haq. (see codename"
					+ " Fair Play) After the successful promulgation of country's constitution in 1973, Chaudhry was elected as"
					+ " the president, succeeded Zulfikar Ali Bhutto, and became the first president of country from the Punjabi"
					+ " class of the Punjab Province. Taking an active role in the Pakistan Movement through the platform of the "
					+ "Muslim League, Chaudhry was appointed minister in the Liaquat Ali Khan government in 1947, and further "
					+ "joined the Pakistan permanent representative's delegation to the United Nations in 1951.His presidency "
					+ "was a mere figurehead as per the constitution, since the heading of the government's operations remained"
					+ " the authority of prime minister. After the success of the Fair Play— a codename of the operation to "
					+ "remove Zulfikar Ali Bhutto from power — Chaudhry continued his presidency but had no influence in the "
					+ "government operations or the military and national affairs. After contentious relations with the"
					+ " military, Chaudhry was relinquished from the office after resigning from his presidency, despite "
					+ "the urging of the Chief of Army Staff and Chairman of Joint Chiefs of Staff. On September 16, 1978,"
					+ " Chaudhry handed the charge of the presidency to ruling military general Zia-ul-Haq who succeeded"
					+ " him as the sixth president, in addition to being the Chief Martial Law Administrator and the Chief "
					+ "of Army Staff.",
			"Muhammad Zia-ul-Haq (12 August 1924 – 17 August 1988), was the sixth President of Pakistan from 1977"
					+ " until his death in 1988, having declared martial law for the third time in the country's history in "
					+ "1977. He was Pakistan's longest-serving head of state, ruling eleven years. He is most noted for his "
					+ "efforts to bring religion into mainstream society within Pakistan, and in foreign policy, for his close "
					+ "relationship with the United States and support for the mujahideen resistance against the Soviets in "
					+ "Afghanistan. After graduating from the Delhi University with a BA degree in History, Zia saw action in"
					+ " World War II as a British Indian Army officer, before opting for Pakistan in 1947 and fighting in the "
					+ "war against India in 1965. In 1970, he led the Pakistani training mission in Jordan, proving instrumental "
					+ "to putting down the Black September insurgency against King Hussein. In recognition, Prime Minister "
					+ "Zulfikar Ali Bhutto approved Zia's appointment to four-star tier, as Chief of Army Staff in 1976, over"
					+ " several senior officers.[6] Following increasing civil disorder, Zia deposed Bhutto (in a coup called "
					+ "Operation Fair Play) and declared martial law over the country in 1977.[7] Bhutto was controversially"
					+ " tried and executed by the Supreme Court less than two years later, for authorising the murder "
					+ "of a political opponent. Assuming the presidency in 1978, Zia played a major role in the Soviet"
					+ " war in neighboring Afghanistan while playing an ambiguous role, in favor of Iran, during the "
					+ "Iran–Iraq War . Aided by the United States and Saudi Arabia, Zia systematically coordinated the"
					+ " Afghan mujahideen against the Soviet occupation throughout the 1980s. This culminated in the "
					+ "Soviet Union's defeat and withdrawal in 1989, but also led to the proliferation of millions of"
					+ " refugees, with heroin and weaponry into Pakistan's frontier province. On the foreign front,"
					+ " Zia also bolstered ties with China, the European Union, the United States, and emphasised "
					+ "Pakistan's role in the Islamic world, while relations with India worsened amid the Siachen "
					+ "conflict and accusations that Pakistan was aiding the Khalistan movement. Domestically, Zia "
					+ "passed broad-ranging legislation as part of Pakistan's Islamization, acts criticised for fomenting "
					+ "religious intolerance. He also escalated Pakistan's atomic bomb project, and instituted "
					+ "industrialisation and deregulation, helping Pakistan's economy become among the fastest-growing"
					+ " in South Asia.[9] Averaged over Zia's rule, GDP growth was the highest in history.After lifting "
					+ "martial law and holding non-partisan elections in 1985, Zia appointed Muhammad Junejo as the Prime"
					+ " Minister but accumulated even more presidential powers via the Eighth Amendment to the Constitution."
					+ " After Junejo signed the Geneva Accords in 1988 against Zia's wishes, and called for an inquiry into "
					+ "the Ojhri Camp disaster, Zia dismissed Junejo's government and announced fresh elections in November 1988."
					+ " But he was killed along with several of his top military officials and two American diplomats in a mysterious"
					+ " plane crash near Bahawalpur on 17 August 1988. To this day, Zia remains a polarizing figure in Pakistan's"
					+ " history, credited by some for preventing wider Soviet incursions into the region as well as economic pros"
					+ "perity, but decried for weakening democratic institutions and passing laws encouraging religious intolerance."
					+ " With the passing of Eighteenth Amendment to the Constitution of Pakistan, General Zia's name was permanently "
					+ "deleted from the Constitution of Pakistan.",
			"Ghulam Ishaq Khan (January 1915 – 27 October 2006), sometimes ab"
					+ "breviated to GIK, was a Pakistani civil servant who served as the 7th President of Pakistan from 1988 "
					+ "until his resignation in 1993, the country's longest-serving civilian President.Born in Bannu District,"
					+ " British India, Ghulam Ishaq was educated at Islamia College Peshawar and Peshawar University where he"
					+ " studied nuclear chemistry. He began his career as a bureaucrat from the Indian Civil Service, then opte"
					+ "d for Pakistan after Partition. Appointed the first chairman of the Water and Power Development Authorit"
					+ "y by President Ayub Khan in 1961, Ghulam Ishaq also served as Finance Secretary from 1966 to 1970. A year "
					+ "later, he was appointed Governor of the State Bank by President Zulfikar Ali Bhutto, before being made Def"
					+ "ence Secretary in 1975, assisting with Pakistan's atomic bomb project. He was retained by President Zia-ul-"
					+ "Haq as Finance Minister in 1977, overseeing the highest GDP growth average in the country's history. Elect"
					+ "ed Chairman of the Senate in 1985, Ghulam Ishaq was elevated to the presidency after Zia's death in an a"
					+ "ir crash on 17 August 1988.As president, Ghulam Ishaq maintained an active role in neighbouring Afghanis"
					+ "tan after the Soviet occupation ended in 1989, while relations with the United States deteriorated when "
					+ "Pakistan was embargoed by the Pressler amendment. Domestically, Ghulam Ishaq's term faced challenging "
					+ "problems; ethnic riots flared in Karachi, currency crises weakened the country's economy, and Prime "
					+ "Minister Benazir Bhutto, newly-elected in 1988, accused him of frustrating her government as part of"
					+ " an alliance with conservative opposition leader Nawaz Sharif and the post-Zia military establishment."
					+ " Ghulam Ishaq invoked the Eight Amendment and dismissed Benazir's government after just 20 months, on "
					+ "charges of corruption and misgovernance.But when Sharif was elected Prime Minister in 1990, the tussle"
					+ " between presidency and premiership grew worse. Ghulam Ishaq attempted to dismiss his government on "
					+ "similar charges but Sharif resisted, appealing to the Supreme Court and having the President's decision "
					+ "overturned. The gridlock ultimately led to the resignation of both men in 1993 in an agreement brokered"
					+ " by army chief Abdul Waheed Kakar. Retiring from public service, Ghulam Ishaq served as rector of the"
					+ " GIK Institute of Engineering Sciences and Technology in his native province. He died from pneumonia on "
					+ "27 October 2006.Ghulam Ishaq Khan is viewed contentiously by Pakistani historians; he is credited for "
					+ "economic growth as Finance Minister and supervising the nuclear programme to completion,but criticized "
					+ "for wielding an autocratic presidency that ousted two elected governments in 1990 and 1993.",
			"Wasim Sajjad(born 30 March 1941), is a Pakistani retired statesman, lawyer, diplomat, professor of law, conservative and"
					+ " Rhodes scholar who served as the Acting President of Pakistan in two nonconsective terms (1996–97; July 1993–November"
					+ " 1993),"
					+ " as well as Chairman of Senate from 1988 until 1999.A technocrat in senate, he is the longest–serving Chairman of Senate"
					+ ", serving in that capacity from 1988 until 1999.[2] Originally representing the PML(N), Sajjad defected to defecting "
					+ "group that supported Pervez Musharraf and has been its Member since 1999.[3] In addition, he favourably nominated to "
					+ "become the Chief Justice of Pakistan in 2003 after the retirement of Sheikh Riaz Ahmad but he declined the offer and "
					+ "preferred to stick to his law profession.After retiring from the national politics, he has been serving as Chancellor "
					+ "of the National University of Computer and Emerging Sciences, chairman of the Youth Hostels Association and the nation"
					+ "al secretary for the Rhodes Scholarship in Pakistan.",
			"Farooq Ahmad Khan Leghari(29 May 1940 – 20 October 2010), was the eighth President of Pakistan, serving from 14 November "
					+ "1993 until voluntarily resgning on 2 December 1997. He is noted as the first Baloch to have been elected as president."
					+ "Educated at the FC College University in Pakistan, and the Oxford University in United Kingdom, he served in the civil"
					+ " bureaucracy and served on political assignments in East-Pakistan in the 1960s until 1970. Generally an apolitical and "
					+ "socialist oriented, Leghari party worker of the Pakistan Peoples Party in the 1970s and was finally named as the presid"
					+ "ential candidate by Benazir Bhutto due to his apolitical vision. He was merely a constitutional and ceremonial figurehead "
					+ "in the Benazir's government; whilst Benazir exercised her authority while running her government. Surprisingly,"
					+ " he dismissed his leader's government after being convinced of Benazir Bhutto and her spouse Asif Ali Zardari's"
					+ " involvement in younger brother's death as well as an economic default was reached at that time.After dismissing,"
					+ " his political ideology clashed with conservative Prime minister Nawaz Sharif, and his intervention to support to "
					+ "Chief Justice Sajjad Ali Shah's matter finally led the resignation of his presidency after being forced by the "
					+ "conservatives and persuaded by the Pakistan Armed Forces in 1997. His relations with Benazir Bhutto too deteriorated "
					+ "which led him to provide his support for dissident group opposing both PPP and PML in May 2004. Since then he stayed "
					+ "away from national politics and died from a long heart illness at the Combined Military Hospital in Rawalpindi on "
					+ "20 October 2010.",
			"Muhammad Rafiq Tarar ( 2 November 1929), is a retired senior justice of the Supreme Court of Pakistan and the ninth"
					+ " President of Pakistan, serving from 1998 until voluntarily resigning in the favour of Pervez Musharraf in 2000.By "
					+ "profession, a jurist, legal and Islamic scholar, Tarar enjoyed a distinguished career in the court system of Pakistan "
					+ "and is a veteran activist of historical Pakistan Movement. By virtue of the extraconstitutional order in 2001, Tarar "
					+ "was controversially replaced by Pervez Musharraf after tendering resignation",
			"Pervez Musharraf( born 11 August 1943), is a Pakistani politician and a retired four-star rank army general who tenured "
					+ "as the tenth President of Pakistan from 2001 until tendering resignation to avoid impeachment in 2008.Prior to seizing "
					+ "the control of the government through a military coup d'état in 1999, Musharraf was serving as the Chairman joint chiefs "
					+ "as well as the Chief of army staff— the appointments he secured in 1998. Although, he was relinquished as Chairman joint"
					+ " chiefs in 2001, Musharraf eventually retired from the military service after retiring from the army in 2007. Commissioned"
					+ " from the Pakistan Army in 1964, his military career played an active role in the settlement in the violent civil war "
					+ "in Afghanistan. Musharraf rose to national prominence when he was elevated to the four-star appointments by then-Prime"
					+ " Minister Nawaz Sharif on October 1998. As appointed, he was a mastermind of a Kargil infiltration that nearly brought"
					+ " India and Pakistan to the brink of war in 1999. After months of contentious relations with Prime Minister Sharif,"
					+ " a staged military coup d'état allowed Musharraf to seize the control of the government when he subsequently placed "
					+ "Prime Minister Sharif under a strict house-arrest before moving towards a trial against Sharif in Adiala Prison.Ad"
					+ "vocating for the Third Way for varying synthesis of conservatism and left wing ideas, he appointed Shaukat Aziz in"
					+ " place of Sharif and directed polices against terrorism, becoming a key player in the American-led war on terror."
					+ " As Shaukat Aziz departed as Prime Minister, and after approving the suspension of the Judicature branch in 2007,"
					+ " Musharraf dramatically weakened from his position in 2008.[4] Tendering his resignation in a threat to face potential"
					+ " impeachment movement led by the ruling Pakistan Peoples Party in 2008, Musharraf departed to London in self-imposed "
					+ "exile in London after returning to Pakistan to participate in the general elections held in 2013. While absent from "
					+ "Pakistan, Musharraf engaged in legal battles after the country's high courts issued warrants for him and Aziz for th"
					+ "eir alleged involvement in the assassinations of Benazir Bhutto and Akbar Bugti. Upon his return, Musharraf was dis"
					+ "qualified from taking part in the elections by High Court judges in April 2013.On 31 March 2014, Musharraf was book"
					+ "ed and charged with high treason for implementing emergency rule and suspending the constitution in 2007."
					+ " His legacy is mixed: his era saw the emergence of a more assertive middle class, but his disregard for "
					+ "civilian institutions weakened the state of Pakistan, according to BBC analysis in 2008.",
			"Muhammad Mian Soomro(born 19 August 1950) is a Pakistani politician who served the Chairman of the "
					+ "Senate of Pakistan from 2003 to 2009. Soomro comes from a renowned political family of Sindh province that"
					+ " has been active in public life since 1923. His father, the late Ahmad Mian Soomro, was a seasoned parliamentarian "
					+ "who was Deputy Speaker of the West Pakistan Assembly and a member of the Senate and helped establish the Senate "
					+ "Committee Systems. He is grandson of Khan Bahadur Haji Moula Bux Soomro, a great political figure. He was the "
					+ "16th Prime Minister of Pakistan from 16 November 2007 to 25 March 2008 and became the Acting President of Pakistan"
					+ " upon the resignation of Pervez Musharraf on 18 August 2008.",
			"Asif Ali Zardari(born 26 July 1955)[2] is a Pakistani politician and current co-chairperson of Pakistan Peoples Party"
					+ ". He served as the 11th President of Pakistan from 2008 to 2013. He is the first ever democratically elected president"
					+ " of Pakistan to have completed his five-year tenure.[3] A Sindhi from a landowning tribe of Hooth Baloch origin, Zardari "
					+ "rose to prominence after his marriage to Benazir Bhutto in 1987, becoming the First Gentleman. Between 1993 and 1996, "
					+ "he held various cabinet positions in the second Bhutto administration including Federal Investment Minister, and "
					+ "Chairperson Pakistan Environmental Protection Council (PAEC).He was arrested on charges of corruption in late 1996,"
					+ " following the collapse of the Bhutto government. Although incarcerated, he nominally served in Parliament after "
					+ "being elected to the National Assembly in 1990 and Senate in 1997. He was released from jail in 2004. He subsequently"
					+ " went into self-exile in Dubai, but returned in December 2007 after Bhutto's assassination. As the Co-Chairman of the"
					+ " PPP, he led his party to victory in the 2008 general elections. He spearheaded a coalition that forced Musharraf to"
					+ " resign and was elected President on 6 September 2008.As president, Zardari had been a consistently strong U.S. ally "
					+ "in the war in Afghanistan, despite prevalent public disapproval of the nation's involvement in the conflict. In late"
					+ " 2008, his government obtained a three-year multi-billion dollar loan package from the International Monetary Fund in "
					+ "an effort to steer the nation out of an economic crisis. In early 2009, his attempt to prevent the reinstatement of "
					+ "Supreme Court judges failed in the face of massive protests led by Nawaz Sharif, his chief political rival. His"
					+ " achievements included the passage of the 18th Amendment in 2010 which reduced his vast presidential powers to "
					+ "that of a ceremonial figurehead. He also held the honor of being the 1st president to address the joint session "
					+ "of parliament for a record six times. His successor Mamnoon Hussain was elected on 30 July 2013. On 8 September "
					+ "2013, Zardari became the country's first president to complete his constitutional term and handed over duties to "
					+ "a democratically elected successor",
			"Mamnoon Hussain (born 23 December 1940) is a Pakistani textile businessman, nationalist conservative, and politician"
					+ " who has served as the President of Pakistan since 9 September 2013.Hussain briefly served as Governor of Sindh in "
					+ "1999; his stint as Governor was cut short by the military coup d'état staged in 1999. After the PML(N) secured majority"
					+ " in general elections held in 2013, Hussain was nominated and elected as President of Pakistan on 30 July 2013."
					+ " During the indirect presidential elections held in 2013, Hussain received 432 votes from the Electoral College "
					+ "out of 704 votes, during which, his competitor Wajihuddin Ahmed received 77 votes.[4] Succeeding outgoing president,"
					+ " Asif Zardari, who did not seek reelection, Hussain took over the presidency after an oath administrated by the Chief "
					+ "Justice of Pakistan on 9 September 2013" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		selectedImage = (ImageView) findViewById(R.id.image1);
		tv_name = (TextView) findViewById(R.id.tv_name_date);
		tv_description = (TextView) findViewById(R.id.tv_discription);
		gallery.setSpacing(2);
		gallery.setAdapter(new GalleryImageAdapter(this));
		selectedImage.setImageResource(mImageIds[0]);
		tv_name.setText(leadersNames[0]);
		tv_description.setText(descript[0]);
		// clicklistener for Gallery
		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// show the selected Image
				selectedImage.setImageResource(mImageIds[position]);
				tv_name.setText(leadersNames[position]);
				tv_description.setText(descript[position]);
			}
		});

	}

}