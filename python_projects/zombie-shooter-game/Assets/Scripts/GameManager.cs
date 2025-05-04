using UnityEngine;

public class GameManager : MonoBehaviour
{
    public static GameManager Instance;

    private int score;
    private bool isGameOver;

    private void Awake()
    {
        if (Instance == null)
        {
            Instance = this;
            DontDestroyOnLoad(gameObject);
        }
        else
        {
            Destroy(gameObject);
        }
    }

    private void Start()
    {
        score = 0;
        isGameOver = false;
    }

    public void AddScore(int points)
    {
        score += points;
        // Update score UI here
    }

    public int GetScore()
    {
        return score;
    }

    public void GameOver()
    {
        isGameOver = true;
        // Handle game over logic here
    }

    public bool IsGameOver()
    {
        return isGameOver;
    }
}