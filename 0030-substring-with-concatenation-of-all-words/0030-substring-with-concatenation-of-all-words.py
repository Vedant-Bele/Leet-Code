class Solution:
    def findSubstring(self, s, words):
        if not s or not words:
            return []
        
        word_len = len(words[0])
        total_words = len(words)
        total_len = word_len * total_words
        
        from collections import Counter
        word_count = Counter(words)
        result = []
        
        for i in range(word_len):
            left = i
            count = 0
            window = {}
            
            for j in range(i, len(s) - word_len + 1, word_len):
                word = s[j:j + word_len]
                
                if word in word_count:
                    window[word] = window.get(word, 0) + 1
                    count += 1
                    
                    while window[word] > word_count[word]:
                        left_word = s[left:left + word_len]
                        window[left_word] -= 1
                        left += word_len
                        count -= 1
                    
                    if count == total_words:
                        result.append(left)
                else:
                    window.clear()
                    count = 0
                    left = j + word_len
        
        return result